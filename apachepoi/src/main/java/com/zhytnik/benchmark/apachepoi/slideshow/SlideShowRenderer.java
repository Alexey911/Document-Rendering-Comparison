package com.zhytnik.benchmark.apachepoi.slideshow;

import com.itextpdf.text.BadElementException;
import com.zhytnik.benchmark.common.Renderer;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.sl.usermodel.SlideShow;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
abstract class SlideShowRenderer<T extends SlideShow, S extends Sheet> implements Renderer<T> {

    protected float dpi = 2f;

    private AffineTransform transform = new AffineTransform();

    {
        setDpi(dpi);
    }

    @Override
    public List<Image> render(T s, int from, int to) throws Exception {
        List<S> slides = getSlides(s);
        Dimension dimension = s.getPageSize();
        final List<Image> images = new ArrayList<>(to - from);
        for (int i = from; i < to; i++) {
            images.add(render(slides.get(i), dimension));
        }
        return images;
    }

    @SuppressWarnings("unchecked")
    private List<S> getSlides(T slideShow) {
        return slideShow.getSlides();
    }

    private Image render(S slide, Dimension dimension) throws IOException, BadElementException {
        final BufferedImage image = createImageBySize(dimension);
        final Graphics2D g = image.createGraphics();
        g.setTransform(transform);
        g.setPaint(getSlideBackground(slide));
        g.fill(new Rectangle(0, 0, dimension.width, dimension.height));
        try {
            slide.draw(g);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return image;
    }

    protected abstract Paint getSlideBackground(S slide);

    private BufferedImage createImageBySize(Dimension dimension) {
        return new BufferedImage(
                scale(dimension.width),
                scale(dimension.height),
                TYPE_INT_RGB);
    }

    private int scale(int size) {
        return (int) (size * dpi);
    }

    @Override
    public void setDpi(float dpi) {
        this.dpi = dpi;
        transform.setToScale(dpi, dpi);
    }
}
