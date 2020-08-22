def binary(array, x,l, r):
    m = int((l + r) / 2)


    if(l<r):
        if x == array[m]:
            return "Found"
        else:
            if x< array[m]:
                return binary(array, x,l, m-1)
            else:
                return binary(array, x, m+1,r)
    return 'Not Found'
array = [1,2,3,4,5,6, 9, 16, 24, 26, 57]
print(binary(array, 24, 0, len(array)))





