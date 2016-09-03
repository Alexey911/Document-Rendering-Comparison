package com.zhytnik.benchmark.apachepoi.slideshow;

import com.itextpdf.text.BadElementException;
import com.zhytnik.benchmark.common.Renderer;
import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveRenderer;
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
abstract class SlideShowRenderer<T extends SlideShow, S extends Sheet>
        implements Renderer<T>, SelectiveRenderer<T>, ResolutionConfigurable {

    protected static final float DEFAULT_DPI = 300f;

    protected float dpi;

    private AffineTransform transform = new AffineTransform();

    public SlideShowRenderer() {
        setDpi(DEFAULT_DPI);
    }

    @Override
    public List<Image> render(T slideshow) throws Exception {
        final List<S> slides = getSlides(slideshow);
        return render(slideshow, slides, 0, slides.size());
    }

    @Override
    public List<Image> render(T slideshow, int begin, int end) throws Exception {
        return render(slideshow, getSlides(slideshow), begin, end);
    }

    @SuppressWarnings("unchecked")
    private List<S> getSlides(T slideShow) {
        return slideShow.getSlides();
    }

    private List<Image> render(T slideshow, List<S> slides, int begin, int end) throws Exception {
        final List<Image> images = new ArrayList<>(end - begin);
        final Dimension dimension = slideshow.getPageSize();
        for (int i = begin; i < end; i++) {
            images.add(render(slides.get(i), dimension));
        }
        return images;
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
        return (int) ((size * dpi) / 150f);
    }

    @Override
    public void setDpi(float dpi) {
        this.dpi = dpi;
        transform.setToScale(dpi / 150f, dpi / 150f);
    }

    @Override
    public float getDpi() {
        return dpi;
    }
}
