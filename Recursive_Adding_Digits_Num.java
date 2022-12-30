/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println(addUp(124));
	}
	
	public static int addUp (int k) {
	    if (k < 0) {
	        return 0;
	    }
	    if (k == 1) {
	        return 1;
	    }
	    return k%10 + addUp(k/10);  
	   
	}
}
