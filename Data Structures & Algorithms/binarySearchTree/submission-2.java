class BinarySearchTree {
    BinarySearchTree left, right;
    int key, val;
    public BinarySearchTree(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class TreeMap {

    private BinarySearchTree root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        BinarySearchTree newNode = new BinarySearchTree(key, val);
        if (root == null) {
            root = newNode;
            return;
        };
        BinarySearchTree current = root;
        while(true) {
            if ( key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if ( key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        BinarySearchTree current = root;
        while(current != null) {
            if (key == root.key) {
                return root.val;
            }
            current = (key < root.key) ? root.left : root.right;
        }
        return -1;
    }

    public int getMin() {
        BinarySearchTree minNode = findMin(root);
        return minNode != null ? minNode.val : -1;
    }

    private BinarySearchTree findMin(BinarySearchTree root) {
        BinarySearchTree node = root;
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        BinarySearchTree maxNode = findMax();
        return maxNode != null ? maxNode.val : -1;
    }

    private BinarySearchTree findMax() {
        BinarySearchTree current = root;
        while(current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private BinarySearchTree removeHelper(BinarySearchTree curr, int key) {
        if (curr == null) {
            return null;
        }

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            if (curr.left == null) {
                // Replace current with right child
                return curr.right;
            } else if (curr.right == null) {
                // Replace current with left child
                return curr.left;
            } else {
                // Swap curr with inorder successor
                BinarySearchTree minNode = findMin(root.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        return inOrderList;
    }

    private void inOrderTraversal(BinarySearchTree root, List<Integer> inOrderList) {
        if (root != null) {
            inOrderTraversal(root.left, inOrderList);
            inOrderList.add(root.key);
            inOrderTraversal(root.right, inOrderList);
        }
    }
}
