/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println(powerUp(10,2));
	}
	
	public static int powerUp (int b, int p) {
	    if (b < 0 || p < 0) {
	        return 0;
	    }
	    if (p == 0) {
	        return 1;
	    }
	    return b*powerUp(b,p-1);  
	   
	}
}
