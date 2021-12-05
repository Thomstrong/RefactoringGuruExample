package refactoring_guru.prototype.example.shapes;

/**
 * @author thomstrong
 */
public class Triangle extends Shape {
    public int a;
    public int b;
    public int c;

    public Triangle() {
    }

    public Triangle(Triangle target) {
        super(target);
        if (target != null) {
            this.a = target.a;
            this.b = target.b;
            this.c = target.c;
        }
    }

    @Override
    public Shape clone() {
        return new Triangle(this);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Triangle) || !super.equals(other)) {
            return false;
        }
        Triangle obj2 = (Triangle) other;
        return this.a == obj2.a && this.b == obj2.b && this.c == obj2.c;
    }
}
