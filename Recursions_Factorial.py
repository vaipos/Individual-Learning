def Factorial_Rec(x):
    if x>=1:
        return x*Factorial_Rec(x-1)
    else:
        return 1

print(Factorial_Rec(3))