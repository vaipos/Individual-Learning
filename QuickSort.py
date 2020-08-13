def quick_sort(array):

    length= len(array)
    if length <= 1:
        return array
    else:
        pivot = array.pop()
    smaller_items = []
    larger_items = []

    for item in array:
        if item > pivot:
            larger_items.append(item)
        else:
            smaller_items.append(item)
    return quick_sort(smaller_items)+ [pivot] + quick_sort(larger_items)

print(quick_sort([3,2,4,2,4,5,1,2,8,2,6,8]))























