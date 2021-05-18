package app;

import app.P3LP;

public class P3LPTestS4S5 {

	
	/*
	 Data is in the report

	 */
	public static double [] lp0(double []r, double []p) {		
		double []k=new double[r.length];

		for(int i=0;i<r.length;i++) {
			k[i]=r[i]-p[i];
		
		}
		return k;
	}
	
	
	public static double [] lp1(double []q, double M) {	
		
		double []k=new double[q.length];
		
		for(int i=0;i<q.length;i++) {
			k[i]=q[i]/M;
		}
		
		
		return k;
	}
	
	public static double [] lp2(double []p) {
		double []k=new double[p.length];
		
		for(int i=0;i<p.length;i++) {
			k[i]=p[i]+1;
		}		
		
		
		
		return k;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

	//-----------------------------------------------------------------------------------------------	
	//---------------------------You can make change below-------------------------------------------	
	//-----------------------------------------------------------------------------------------------
		double M=2;//amount of Capital
		double a=2.05;//Risk up limit: a
		int MaxMin=1;//1 means Max and -1 means Min for the objective function. 
		int ConstraintNum=3;//Number of constraints
		int VariableNum=2;//Number of variables
		int SmallerNum=2;//Number of constraints of <=
		int EqualNum=1;//Number of constraints of =
		int GreaterNum=0;//Number of constraints of >=
		
		
		//S1&S2 All the formulas should be listed in order of: <=,=,>=
		/*
		double[]r={0.28,0.21};
		double[]q1={2.5,0};
		double[]q2={0,1.5};
		double[]p={0.01,0.02};		
		
		 */
		
		
		//S4&S5 All the formulas should be listed in order of: <=,=,>=
		double[]r={0.25,0.22};//Returns Ri
		double[]q1={2.1,0};//Risk Rate Q1
		double[]q2={0,2.0};//Risk Rate Q2
		double[]p={0.065,0.05};//Transaction Fee Pi
	//-----------------------------------------------------------------------------------------------
	//---------------------------You can make change above-------------------------------------------		
	//-----------------------------------------------------------------------------------------------		
		
		

		double[]k0=new double[r.length];
		double[]k1a=new double[r.length];
		double[]k1b=new double[r.length];
		double[]k2=new double[r.length];
		

		
		//Arrays k0,k1a,k1b and k2 calculate coefficients automatically 
		k0=lp0(r,p);
		k1a=lp1(q1,M);
		k1b=lp1(q2,M);
		k2=lp2(p);
		System.out.println(k0[0]+","+k0[1]);
		System.out.println(k1a[0]+","+k1b[1]);
		System.out.println(k2[0]+","+k2[1]);
		
		double d[][] = {
				

				
				{q1[0],q1[1],a},//Q1X1/M<=a
				{q2[0],q2[1],a},//Q2X2/M<=a
				{k2[0],k2[1],M}//(1+Pi)Xi=M
				
				
				
				};//coefficient matrix
		double x[] = {k0[0],k0[1]};//coefficient of objective function
		P3LP lp = new P3LP(MaxMin,ConstraintNum,VariableNum,SmallerNum,EqualNum,GreaterNum,d,x);
		lp.solve();

	}

}
