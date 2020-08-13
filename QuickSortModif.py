def partition(list, min_index, max_index):
    index = (min_index - 1)
    pivot = list[max_index]
    for i in range(min_index, max_index):
        if list[i] <= pivot:
            index = index + 1
            list[index], list[i] = list[i], list[index]
            print(list)
    list[index + 1], list[max_index] = list[max_index], list[index + 1]
    print(pivot)
    print(list)

    return (index + 1)

def Quick_sort_modif(list, min_index, max_index):
    if min_index < max_index:
        pi = partition(list, min_index, max_index)
        Quick_sort_modif(list, min_index, pi - 1)
        Quick_sort_modif(list, pi + 1, max_index)

list = [1,9,2,3,2,4,5]
length = len(list)
Quick_sort_modif(list, 0, length - 1)
print("Sorted array is:")
for i in range(length):
    print("%d" % list[i])
