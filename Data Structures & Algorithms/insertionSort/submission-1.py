# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
class Solution:
    def insertionSort(self, pairs: List[Pair]) -> List[List[Pair]]:
        if len(pairs) == 0:
            return pairs
        res: List[List[Pair]] = []
        res.append(pairs[:])
        for i in range(1, len(pairs)):
            j = i - 1
            while j >= 0 and pairs[j].key > pairs[j + 1].key:
                tmp = pairs[j + 1]
                pairs[j + 1] = pairs[j]
                pairs[j] = tmp
                j -= 1
            res.append(pairs[:])
        return res


# [[(3, "cat"), (3, "bird"), (2, "dog")], [(3, "cat"), (2, "dog"), (3, "bird")], [(2, "dog"), (3, "cat"), (3, "bird")], [(2, "dog"), (3, "cat"), (3, "bird")]]
# [[(3, "cat"), (3, "bird"), (2, "dog")], [(3, "cat"), (3, "bird"), (2, "dog")], [(2, "dog"), (3, "cat"), (3, "bird")]]