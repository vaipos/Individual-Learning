def heapify(sequence, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    if l < n and sequence[i] < sequence[l]:
        largest = l
    if r < n and sequence[largest] < sequence[r]:
        largest = r
    if largest != i:
        sequence[i], sequence[largest] = sequence[largest], sequence[i]
        heapify(sequence, n, largest)

def heapSort(sequence):
    n = len(sequence)
    for i in range(n // 2 - 1, -1, -1):
        heapify(sequence, n, i)

    for i in range(n - 1, 0, -1):
        sequence[i], sequence[0] = sequence[0], sequence[i]
        heapify(sequence, i, 0)

sequence = [12, 11, 13, 5, 6, 7]
heapSort(sequence)
n = len(sequence)
print("Sorted array is")
for i in range(n):
    print("%d" % sequence[i]),