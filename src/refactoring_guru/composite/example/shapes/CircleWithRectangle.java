package refactoring_guru.composite.example.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author thomstrong
 */
public class CircleWithRectangle extends BaseShape {
    protected List<Shape> components = new ArrayList<>();


    public CircleWithRectangle(Shape... shapes) throws Exception {
        super(0, 0, Color.BLACK);
        add(shapes);
    }

    public void add(Shape shape) throws Exception {
        if (!(shape instanceof Circle) && !(shape instanceof Rectangle)) {
            throw new Exception("shape should be Circle or Rectangle");
        }
        this.components.add(shape);
    }

    public void add(Shape... shapes) throws Exception {
        for (Shape shape : shapes) {
            add(shape);
        }
    }

    public void remove(Shape shape) {
        this.components.remove(shape);
    }

    public void remove(Shape... shapes) {
        this.components.removeAll(Arrays.asList(shapes));
    }

    @Override
    public int getX() {
        if (this.components.isEmpty()) {
            return 0;
        }
        int x = components.get(0).getX();
        for (Shape child : components) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (components.isEmpty()) {
            return 0;
        }
        int y = components.get(0).getY();
        for (Shape child : components) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        if (components.isEmpty()) {
            return 0;
        }

        int left = components.get(0).getX();
        int right = components.get(0).getX() + components.get(0).getWidth();

        for (Shape shape : components) {
            if (shape.getX() < left) {
                left = shape.getX();
            }
            if (shape.getX() + shape.getWidth() > right) {
                right = shape.getX() + shape.getWidth();
            }
        }

        return right - left;
    }

    @Override
    public int getHeight() {
        if (components.isEmpty()) {
            return 0;
        }

        int top = components.get(0).getY();
        int bottom = components.get(0).getY() + components.get(0).getHeight();

        for (Shape shape : components) {
            if (shape.getY() < top) {
                top = shape.getY();
            }
            if (shape.getY() + shape.getHeight() > bottom) {
                bottom = shape.getY() + shape.getHeight();
            }
        }

        return bottom - top;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : components) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : components) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : components) {
            child.unSelect();
        }
    }

    public boolean selectChildAt(int x, int y) {
        for (Shape child : components) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (refactoring_guru.composite.example.shapes.Shape child : components) {
            child.paint(graphics);
        }
    }


}
