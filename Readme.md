# Performance comparison rendering of PDF, PPT, PPTX, DOC, DOCX formats

## Ghost4J
- **input formats**: InputStream, File.
- **features**: dpi, antialiasing, multiprocessing.
- **low-level details**: has a thread-pool with 10 threads, using com.sun.jna.

## ICEpdf
- **input formats**: InputStream, byte[], String (path to file).
-	**features**: dpi, compression, page rotation.

## PDFBox
- **input formats**: InputStream, File, byte[].
-	**features**: dpi, buffering loading (memory & file), security (password or keystore), color schema.

## PDFRenderer
- **input formats**: byte[].
- **features**: dpi, page rotation, multiprocessing, security (password), support custom image observer.
- **low-level details**: reserved a thread for async processing, active usage float[].

## Apache POI
- **input formats**: InputStream.
- **features**: dpi.

## JodConverter
- **input formats**: InputStream.
- **features**: dpi.