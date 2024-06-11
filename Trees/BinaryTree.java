package DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class representing a Binary Tree data structure. Provides various methods to
 * manipulate and traverse the binary tree. Includes implementations for
 * insertion, traversal, searching, and other utility functions.
 *
 * @author nihar
 */
public class BinaryTree {

    int data;
    BinaryTree leftChild;
    BinaryTree rightChild;

    /**
     * Constructor to initialize a BinaryTree node with a given value.
     *
     * @param val the value to be stored in the node.
     */
    public BinaryTree(int val) {
        data = val;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Inserts a new node with the specified value as the left child of the
     * current node.
     *
     * @param val the value to be stored in the new left child node.
     * @return the newly created left child node.
     */
    public BinaryTree insertLeft(int val) {
        BinaryTree left = new BinaryTree(val);
        if (this.leftChild == null) {
            this.leftChild = left;
        } else {
            left.leftChild = this.leftChild;
            this.leftChild = left;
        }
        return left;
    }

    /**
     * Inserts a new node with the specified value as the right child of the
     * current node.
     *
     * @param val the value to be stored in the new right child node.
     * @return the newly created right child node.
     */
    public BinaryTree insertRight(int val) {
        BinaryTree right = new BinaryTree(val);
        if (this.rightChild == null) {
            this.rightChild = right;
        } else {
            right.rightChild = this.rightChild;
            this.rightChild = right;
        }
        return right;
    }

    /**
     * Depth-First Search (DFS) Pre-order traversal of the binary tree.
     *
     * @param root the root node of the binary tree.
     */
    public void dfs(BinaryTree root) {
        System.out.println(root.data);
        if (root.leftChild != null) {
            dfs(root.leftChild);
        }
        if (root.rightChild != null) {
            dfs(rightChild);
        }
    }

    /**
     * Static method for DFS Pre-order traversal.
     *
     * @param root the root node of the binary tree.
     */
    public static void preOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        if (root.leftChild != null) {
            preOrder(root.leftChild);
        }
        if (root.rightChild != null) {
            preOrder(root.rightChild);
        }
    }

    /**
     * Static method for DFS Pre-order traversal without recursion.
     *
     * @param root the root node of the binary tree.
     */
    public static void preOrderWOR(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree cur = stack.pop();
            System.out.println(cur.data);

            if (cur.rightChild != null) {
                stack.push(cur.rightChild);
            }
            if (cur.leftChild != null) {
                stack.push(cur.leftChild);
            }
        }
    }

    /**
     * Static method for DFS Post-order traversal.
     *
     * @param root the root node of the binary tree.
     */
    public static void postOrder(BinaryTree root) {
        if (root.leftChild != null) {
            postOrder(root.leftChild);
        }
        if (root.rightChild != null) {
            postOrder(root.rightChild);
        }
        System.out.println(root.data);
    }

    /**
     * DFS In-order traversal of the binary tree.
     *
     * @param root the root node of the binary tree.
     */
    public void inOrder(BinaryTree root) {
        if (root.leftChild != null) {
            inOrder(root.leftChild);
        }
        System.out.println(root.data);
        if (root.rightChild != null) {
            inOrder(root.rightChild);
        }
    }

    /**
     * Breadth-First Search (BFS) traversal of the binary tree.
     *
     * @param root the root node of the binary tree.
     */
    public static void bfs(BinaryTree root) {
        Queue<BinaryTree> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        while (!bfsQ.isEmpty()) {
            BinaryTree currentNode = bfsQ.poll();
            System.out.print(currentNode.data);
            if (currentNode.leftChild != null) {
                bfsQ.offer(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                bfsQ.offer(currentNode.rightChild);
            }
        }
        System.out.println("");
    }

    /**
     * Finds the maximum value in the binary tree using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the maximum value in the binary tree.
     */
    public static int findMax(BinaryTree root) {
        int max = Integer.MIN_VALUE;
        return findMax(root, max);
    }

    /**
     * Helper method for finding the maximum value in the binary tree using
     * recursion.
     *
     * @param root the root node of the binary tree.
     * @param max the current maximum value.
     * @return the maximum value in the binary tree.
     */
    private static int findMax(BinaryTree root, int max) {
        if (root == null) {
            return max;
        }
        max = Integer.max(root.data, max);
        max = findMax(root.leftChild, max);
        max = findMax(root.rightChild, max);
        return max;
    }

    /**
     * Finds the maximum value in the binary tree without using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the maximum value in the binary tree.
     */
    public static int findMaxWOR(BinaryTree root) {
        int max = Integer.MIN_VALUE;
        Queue<BinaryTree> mQ = new LinkedList<>();
        mQ.offer(root);
        while (!mQ.isEmpty()) {
            BinaryTree curr = mQ.poll();
            max = Integer.max(max, curr.data);
            if (curr.leftChild != null) {
                mQ.offer(curr.leftChild);
            }
            if (curr.rightChild != null) {
                mQ.offer(curr.rightChild);
            }
        }
        return max;
    }

    /**
     * Searches for a node with the specified value in the binary tree using
     * recursion.
     *
     * @param root the root node of the binary tree.
     * @param val the value to be searched.
     * @return true if the value is found, false otherwise.
     */
    public static boolean searchNode(BinaryTree root, int val) {
        if (root == null) {
            return false;
        }
        return root.data == val || searchNode(root.leftChild, val) || searchNode(root.rightChild, val);
    }

    /**
     * Searches for a node with the specified value in the binary tree without
     * using recursion.
     *
     * @param root the root node of the binary tree.
     * @param val the value to be searched.
     * @return true if the value is found, false otherwise.
     */
    public static boolean searchNodeWOR(BinaryTree root, int val) {
        Queue<BinaryTree> sQ = new LinkedList<>();
        sQ.offer(root);
        while (!sQ.isEmpty()) {
            BinaryTree curr = sQ.poll();
            if (curr.data == val) {
                return true;
            }
            if (curr.leftChild != null) {
                sQ.offer(curr.leftChild);
            }
            if (curr.rightChild != null) {
                sQ.offer(curr.rightChild);
            }
        }
        return false;
    }

    /**
     * Calculates the height of the binary tree using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the height of the binary tree.
     */
    public static int heightOfTree(BinaryTree root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = heightOfTree(root.leftChild);
            int rightHeight = heightOfTree(root.rightChild);
            return Integer.max(rightHeight, leftHeight) + 1;
        }
    }

    /**
     * Calculates the height of the binary tree without using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the height of the binary tree.
     */
    public static int heightOfTreeWOR(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        Queue<BinaryTree> hQ = new LinkedList<>();
        hQ.offer(root);
        hQ.offer(null);
        int level = 0;
        while (!hQ.isEmpty()) {
            BinaryTree cur = hQ.poll();
            if (cur == null) {
                level++;
                if (!hQ.isEmpty()) {
                    hQ.offer(null);
                }
            } else {
                if (cur.leftChild != null) {
                    hQ.offer(cur.leftChild);
                }
                if (cur.rightChild != null) {
                    hQ.offer(cur.rightChild);
                }
            }
        }
        return level;
    }

    /**
     * Finds the deepest node in the binary tree.
     *
     * @param root the root node of the binary tree.
     * @return the deepest node in the binary tree.
     */
    public static BinaryTree getDeepestNodeData(BinaryTree root) {
        BinaryTree cur = null;
        if (root == null) {
            return null;
        }
        Queue<BinaryTree> dN = new LinkedList<>();
        dN.offer(root);
        while (!dN.isEmpty()) {
            cur = dN.poll();
            if (cur.leftChild != null) {
                dN.offer(cur.leftChild);
            }
            if (cur.rightChild != null) {
                dN.offer(cur.rightChild);
            }
        }
        return cur;
    }

    /**
     * Counts the number of leaf nodes in the binary tree without using
     * recursion.
     *
     * @param root the root node of the binary tree.
     * @return the number of leaf nodes in the binary tree.
     */
    public static int countLeafNodes(BinaryTree root) {
        if (root == null) {
            return 0;  // Return zero if the tree is empty
        }
        Queue<BinaryTree> lQ = new LinkedList<>();
        lQ.offer(root);
        int leafNodes = 0;
        while (!lQ.isEmpty()) {
            BinaryTree cur = lQ.poll();
            if (cur.leftChild == null && cur.rightChild == null) {
                leafNodes++;
            }
            if (cur.leftChild != null) {
                lQ.offer(cur.leftChild);
            }
            if (cur.rightChild != null) {
                lQ.offer(cur.rightChild);
            }
        }
        return leafNodes;
    }

    /**
     * Counts the number of full nodes (nodes with two children) in the binary
     * tree without using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the number of full nodes in the binary tree.
     */
    public static int countFullNodes(BinaryTree root) {
        if (root == null) {
            return 0;  // Return zero if the tree is empty
        }
        Queue<BinaryTree> fN = new LinkedList<>();
        fN.offer(root);
        int fullNodes = 0;
        while (!fN.isEmpty()) {
            BinaryTree cur = fN.poll();
            if (cur.leftChild != null && cur.rightChild != null) {
                fullNodes++;
            }
            if (cur.leftChild != null) {
                fN.offer(cur.leftChild);
            }
            if (cur.rightChild != null) {
                fN.offer(cur.rightChild);
            }
        }
        return fullNodes;
    }

    /**
     * Counts the number of half nodes (nodes with only one child) in the binary
     * tree without using recursion.
     *
     * @param root the root node of the binary tree.
     * @return the number of half nodes in the binary tree.
     */
    public static int countHalfNodes(BinaryTree root) {
        if (root == null) {
            return 0;  // Return zero if the tree is empty
        }
        Queue<BinaryTree> hN = new LinkedList<>();
        hN.offer(root);
        int halfNodes = 0;
        while (!hN.isEmpty()) {
            BinaryTree cur = hN.poll();
            if (cur.leftChild != null ^ cur.rightChild != null) {
                halfNodes++;
            }
            if (cur.leftChild != null) {
                hN.offer(cur.leftChild);
            }
            if (cur.rightChild != null) {
                hN.offer(cur.rightChild);
            }
        }
        return halfNodes;
    }

    /**
     * Checks if two binary trees are identical.
     *
     * @param root1 the root node of the first binary tree.
     * @param root2 the root node of the second binary tree.
     * @return true if the trees are identical, false otherwise.
     */
    public static boolean identicalTrees(BinaryTree root1, BinaryTree root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        }
        return root1.data == root2.data && identicalTrees(root1.leftChild, root2.leftChild)
                && identicalTrees(root1.rightChild, root2.rightChild);
    }

    /**
     * Finds the diameter of the binary tree. The diameter is defined as the
     * number of nodes on the longest path between two leaves in the tree.
     *
     * @param root the root node of the binary tree.
     * @return the diameter of the binary tree.
     */
    public static int findDiameter(BinaryTree root) {
        return heightOfTree(root.leftChild) + heightOfTree(root.rightChild) + 1;
    }

    /**
     * Finds the level with the maximum sum of node values.
     *
     * @param root the root node of the binary tree.
     * @return the level with the maximum sum of node values.
     */
    public static int maxSumLevel(BinaryTree root) {
        if (root == null) {
            return -1;  // Return -1 to clearly indicate the tree is empty
        }
        int level = 0;
        Queue<BinaryTree> sQ = new LinkedList<>();
        sQ.offer(root);
        sQ.offer(null);
        int maxSum = 0;
        int maxSumLevel = 0;
        int sum = 0;
        while (!sQ.isEmpty()) {
            BinaryTree cur = sQ.poll();
            if (cur == null) {
                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumLevel = level;
                }
                sum = 0;
                level++;
                if (!sQ.isEmpty()) {
                    sQ.offer(null);
                }
            } else {
                sum += cur.data;
                if (cur.leftChild != null) {
                    sQ.offer(cur.leftChild);
                }
                if (cur.rightChild != null) {
                    sQ.offer(cur.rightChild);
                }
            }
        }
        return maxSumLevel;
    }

    /**
     * Prints all root-to-leaf paths in the binary tree.
     *
     * @param root the root node of the binary tree.
     */
    public static void printAllRootToLeaf(BinaryTree root) {
        ArrayList<Integer> path = new ArrayList<>();
        printPathRecurr(root, path);
    }

    /**
     * Helper method for printing all root-to-leaf paths in the binary tree.
     *
     * @param node the current node being traversed.
     * @param path the current path from root to the current node.
     */
    private static void printPathRecurr(BinaryTree node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);

        if (node.leftChild == null && node.rightChild == null) {
            printPath(path);
        } else {
            printPathRecurr(node.leftChild, path);
            printPathRecurr(node.rightChild, path);
        }
        // Remove current node from path (backtracking)
        path.remove(path.size() - 1);
    }

    /**
     * Prints the path stored in the list.
     *
     * @param path the list representing the current path.
     */
    private static void printPath(ArrayList<Integer> path) {
        for (int i : path) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    /**
     * Checks if there is a root-to-leaf path in the binary tree with the
     * specified sum.
     *
     * @param root the root node of the binary tree.
     * @param sum the target sum.
     * @return true if there is a root-to-leaf path with the specified sum,
     * false otherwise.
     */
    public static boolean hasPathSum(BinaryTree root, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum - root.data;
        if (sum == 0) {
            return true;
        }
        return hasPathSum(root.leftChild, sum) || hasPathSum(root.rightChild, sum);
    }

    /**
     * Mirrors the binary tree.
     *
     * @param root the root node of the binary tree.
     * @return the root node of the mirrored binary tree.
     */
    public static BinaryTree mirrorBinaryTree(BinaryTree root) {
        if (root == null) {
            return root;
        }
        mirrorBinaryTree(root.leftChild);
        mirrorBinaryTree(root.rightChild);
        BinaryTree temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        return root;
    }

    /**
     * Finds the least common ancestor (LCA) of two nodes in the binary tree.
     *
     * @param root the root node of the binary tree.
     * @param a the first node.
     * @param b the second node.
     * @return the LCA of the two nodes.
     */
    public static BinaryTree leastCommonAncestor(BinaryTree root, BinaryTree a, BinaryTree b) {
        if (root == null) {
            return root;
        }
        if (root.data == a.data || root.data == b.data) {
            return root;
        }
        BinaryTree left = leastCommonAncestor(root.leftChild, a, b);
        BinaryTree right = leastCommonAncestor(root.rightChild, a, b);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
