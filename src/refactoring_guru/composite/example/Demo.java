package refactoring_guru.composite.example;

import refactoring_guru.composite.example.shapes.Circle;
import refactoring_guru.composite.example.shapes.CompoundShape;
import refactoring_guru.composite.example.shapes.Dot;
import refactoring_guru.composite.example.shapes.Rectangle;
import refactoring_guru.composite.example.editor.ImageEditor;
import refactoring_guru.composite.example.shapes.*;

import java.awt.Color;

public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        try {
            CircleWithRectangle circleWithRectangle = new CircleWithRectangle(
                    new Rectangle(450, 450, 100, 100, Color.BLUE),
                    new Circle(450, 450, 100, Color.RED),
                    new Circle(300, 500, 100, Color.GREEN)
            );
            Rectangle roundCircleWithRect = new Rectangle(circleWithRectangle.getX(),circleWithRectangle.getY(), circleWithRectangle.getWidth(), circleWithRectangle.getHeight(), Color.GRAY);
            circleWithRectangle.add(roundCircleWithRect);
            editor.loadShapes(
                    new Circle(0, 0, 10, Color.BLUE),

                    new CompoundShape(
                            new Circle(110, 110, 50, Color.RED),
                            new Dot(160, 160, Color.RED)
                    ),

                    new CompoundShape(
                            new Rectangle(250, 250, 100, 100, Color.GREEN),
                            new Dot(240, 240, Color.GREEN),
                            new Dot(240, 360, Color.GREEN),
                            new Dot(360, 360, Color.GREEN),
                            new Dot(360, 240, Color.RED)
                    ),
                    circleWithRectangle
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}