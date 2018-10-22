package dtree;

import java.util.ArrayList;

public class Row {
	public double decision;
	double [] val;
	int size;
	
	public Row(double [] val)
	{
		this.val=val;
		decision=val[57];
		this.size=58;
	}
	
	public double get(int index)
	{
		return val[index];
	}
}
