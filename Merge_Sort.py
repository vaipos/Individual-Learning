def merge_sort(sequence):

    if len(sequence) <= 1:
        return sequence

    middle = int(len(sequence)/2)

    left = merge_sort(sequence[:middle])
    right =merge_sort(sequence[middle:])

    return merge(left, right)

def merge(left, right):
    end_List = []
    left_pointer = 0
    right_pointer = 0

    while left_pointer < len(left) and right_pointer < len(right):

        if left[left_pointer] < right[right_pointer]:

            end_List.append(left[left_pointer])
            left_pointer += 1

        else:
            end_List.append(right[right_pointer])
            right_pointer += 1


    end_List.extend(left[left_pointer:])
    end_List.extend(right[right_pointer:])

    return end_List
sequence = [3,2,3,1,3,4,5,6,3]
print (sequence)

print(merge_sort(sequence))








