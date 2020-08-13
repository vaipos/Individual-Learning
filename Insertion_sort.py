def insertion_sort(sequence):
    indexing_length = range(1, len(sequence))
    for i in indexing_length:
        value_to_sort = sequence[i]

        while sequence[i - 1] > value_to_sort and i > 0:
            sequence[i], sequence[i - 1] = sequence[i - 1], sequence[i]
            i = i - 1

    return sequence


print(insertion_sort([12, 12, 1, 3, 1, 3, 5, 6, 3, 4, 5, 6, 3, 5, 8, 5, 6]))
