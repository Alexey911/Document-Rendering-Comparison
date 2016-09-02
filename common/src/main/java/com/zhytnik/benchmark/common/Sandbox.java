package com.zhytnik.benchmark.common;

import java.io.FilePermission;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.security.AccessController.doPrivileged;

/**
 * @author Alexey Zhytnik
 * @since 02.09.2016
 */
public class Sandbox<T> {

    private static final Permission DISABLED_WRITE = new FilePermission("/", "read");

    private static final Permission[] DEFAULT_PERMISSIONS = {DISABLED_WRITE};

    private Permission[] permissions;

    public Sandbox() {
        this.permissions = DEFAULT_PERMISSIONS;
    }

    public Sandbox(Permission... permissions) {
        this.permissions = Stream.of(DEFAULT_PERMISSIONS, permissions)
                .flatMap(Stream::of)
                .toArray(Permission[]::new);
    }

    public T execute(Supplier<T> supplier) {
        return doPrivileged(
                (PrivilegedAction<T>) supplier::get,
                AccessController.getContext(),
                permissions
        );
    }
}
