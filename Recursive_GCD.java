/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println(gcd(18,12));
	}
	
	public static int gcd(int n, int m) {
	    if (n < 0 || m < 0) {
	        return 0;
	    }
	    if (m==0) {
	        return n;
	    }
	    return gcd(m, n%m);  
	   
	}
}
