package flatten;

/**
 * A type that stores three values of the same type.
 */
public class Triple<V> {
	
	private final V l, m, r;

	public Triple(V l, V m, V r) {
		this.l = l;
        this.m = m;
		this.r = r;
	}

	public V left() {
		return l;
	}

    public V middle() {
        return m;
    }

	public V right() {
		return r;
	}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triple{");
        sb.append("l=").append(l);
        sb.append(", m=").append(m);
        sb.append(", r=").append(r);
        sb.append('}');
        return sb.toString();
    }
}
