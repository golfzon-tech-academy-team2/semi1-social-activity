package com.team2.sa.board.model;

import java.util.Objects;

public class BoardVOJoin extends BoardVO {
	private String wName;

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(wName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVOJoin other = (BoardVOJoin) obj;
		return Objects.equals(wName, other.wName);
	}

	@Override
	public String toString() {
		return "BoardVOJoin [wName=" + wName + "]";
	}

}
