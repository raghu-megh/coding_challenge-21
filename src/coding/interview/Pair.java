package coding.interview;

public class Pair<M, N> {
	private M m;
	private N n;

	public Pair(M m, N n) {
		this.m = m;
		this.n = n;
	}

	public M getFirst() {
		return m;
	}

	public N getSecond() {
		return n;
	}

	@Override
	public String toString() {
		return m + ":" + n;
	}
}
