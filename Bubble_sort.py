def bubble_sort(sequence):
    indexing_length = len(sequence) - 1
    done = False

    while not done:
        done = True
        for i in range(0, indexing_length):
            if sequence[i] > sequence[i + 1]:
                done = False
                sequence[i], sequence[i + 1] = sequence[i + 1], sequence[i]
    return sequence
print(bubble_sort([4, 9, 10, 6, 18, 20]))
