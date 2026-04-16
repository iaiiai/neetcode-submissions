from typing import Optional


class Deque:

    class Node:
        def __init__(self, value: "int", prev: "Deque.Node | None" = None, next: "Deque.Node | None" = None):
            self.value = value
            self.prev: Optional[Deque.Node] = prev
            self.next: Optional[Deque.Node] = next
    
    def __init__(self):
        self.head: "Deque.Node | None" = None
        self.tail: "Deque.Node | None" = self.head
        self.current: "Deque.Node | None" = self.head

    def isEmpty(self) -> bool:
        if self.head is None:
            return True
        return False

    def append(self, value: int) -> None:
        new_node: Deque.Node = Deque.Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.prev = self.tail
            if self.tail:
                self.tail.next = new_node
            self.tail = new_node

    def appendleft(self, value: int) -> None:
        new_node: Deque.Node = Deque.Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node
            

    def pop(self) -> int:
        popval = -1
        if (self.tail is self.head) and (self.tail and self.head):
            popval = self.tail.value
            self.head = None
            self.tail = None
            return popval
        if self.tail is None:
            return popval
        else:
            popval = self.tail.value
            self.tail = self.tail.prev
            if self.tail:
                self.tail.next = None
            return popval

    def popleft(self) -> int:
        popval = -1
        if (self.tail is self.head) and (self.tail and self.head):
            popval = self.tail.value
            self.head = None
            self.tail = None
            return popval
        if self.head is None:
            return popval
        else:
            popval = self.head.value
            self.head = self.head.next
            if self.head:
                self.head.prev = None
            return popval
    
    def __repr__(self) -> str:
        head = self.head
        str = "["
        while head:
            if head.prev != None:
                str += f"<{head.prev.value}, {head.value}> "
                head = head.next
                continue
            str += f"{head.value}"
            head = head.next
        return str + "]"