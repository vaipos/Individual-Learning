def binary_search(array,x):
    length = len(array)-1
    left= 0
    right = length

    while left < right:
        midpoint = int((left + right + 1) / 2)

        if x> array[midpoint]:
            left= midpoint +1

        elif x< array[midpoint]:
            right= midpoint-1
        else:
            print("found")
            return midpoint

    print("not found")


binary_search([1,2,4,5,6],7)