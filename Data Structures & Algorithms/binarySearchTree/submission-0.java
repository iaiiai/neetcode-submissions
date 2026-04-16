public class TreeMap {

    class Node {
        int key;
        int val;
        Node left;
        Node right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public Node(int key, int val, Node left, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node tree;

    public TreeMap() {
        this.tree = null;
    }

    private Node dfsAndInsert(Node root, Node insertion) {
        if (root == null) {
            return insertion;
        }
        if (insertion.key > root.key) {
            root.right = dfsAndInsert(root.right, insertion);
        } else if (insertion.key < root.key) {
            root.left = dfsAndInsert(root.left, insertion);
        } else {
            return insertion;
        }
        return root;
    }

    public void insert(int key, int val) {
        Node insertion = new Node(key, val);
        if (this.tree == null) {
            this.tree = insertion;
            return;
        }
        this.tree = dfsAndInsert(this.tree, insertion);
    }

    private Node dfsGet(Node root, int key) {
        if (root == null) {
            return null;
        }
        Node res = null;
        if (key > root.key) {
            res = dfsGet(root.right, key);
        } else if (key < root.key) {
            res = dfsGet(root.left, key);
        } else {
            res = root;
        }
        return res;
    }

    public int get(int key) {
       Node res = dfsGet(this.tree, key);
       if (res == null) {
           return -1;
       }
       return res.val;
    }

    public int getMin() {
        Node root = this.tree;
        if (root == null) {
            return -1;
        }
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int getMax() {
        Node root = this.tree;
        if (root == null) {
            return -1;
        }
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    private Node getMinValueNode(Node root) {
        Node curr = root;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public Node dfsAndRemove(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = dfsAndRemove(root.left, key);
        } else if (key > root.key) {
            root.right = dfsAndRemove(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node minNode = getMinValueNode(root.right);
                root.key = minNode.key;
                root.val = minNode.val;
                root.right = dfsAndRemove(root.right, minNode.key);
            }
        }
        return root;
    }

    public void remove(int key) {
        if (this.tree == null) {
            return;
        }
        this.tree = dfsAndRemove(this.tree, key);
        return;
    }

    private void formInorderList(Node root, List<Integer>res) {
        if (root == null) {
            return;
        }
        formInorderList(root.left, res);
        res.add(root.key);
        formInorderList(root.right, res);
    }
    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<Integer>();
        formInorderList(this.tree, res);
        return res;
    }
    public void print(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        int height = getHeight(root);
        List<List<String>> lines = new ArrayList<>();
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    line.add("[" + String.valueOf(n.key) + "]" + " " + String.valueOf(n.val));
                    next.add(n.left);
                    next.add(n.right);
                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            lines.add(line);
            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1).size() * (height + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    // Draw branch connections
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) c = (line.get(j) != null) ? '┴' : '┘';
                        else if (line.get(j) != null) c = '└';
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) System.out.print(" ");
                    } else {
                        for (int k = 0; k < hpw; k++) System.out.print(j % 2 == 0 ? " " : "─");
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) System.out.print(j % 2 == 0 ? "─" : " ");
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                for (int k = 0; k < gap1; k++) System.out.print(" ");
                System.out.print(f);
                for (int k = 0; k < gap2; k++) System.out.print(" ");
            }
            System.out.println();
            perPiece /= 2;
        }
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}