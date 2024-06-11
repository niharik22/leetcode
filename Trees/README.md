# Binary Tree Implementation in Java

This project provides an implementation of the Binary Tree data structure in Java. It includes various methods for manipulating and traversing the binary tree, such as insertion, traversal, searching, height calculation, node counting, path operations, and tree manipulation.

## Features

- **Insertion**: Insert nodes as left or right children.
- **Traversal**: Depth-First Search (DFS) pre-order, post-order, in-order traversals, and Breadth-First Search (BFS) traversal.
- **Searching**: Search for nodes recursively and non-recursively.
- **Height Calculation**: Calculate the height of the tree recursively and non-recursively.
- **Maximum Value**: Find the maximum value in the tree recursively and non-recursively.
- **Node Count**: Count the number of leaf nodes, full nodes, and half nodes.
- **Tree Properties**: Check if two trees are identical and find the diameter of the tree.
- **Path Operations**: Print all root-to-leaf paths, check for a root-to-leaf path with a specified sum.
- **Tree Manipulation**: Mirror the tree and find the least common ancestor of two nodes.

## Usage

Here are some examples of how to use the methods provided in the `BinaryTree` class:

### Insertion

```java
BinaryTree root = new BinaryTree(1);
root.insertLeft(2);
root.insertRight(3); 
```

### Traversal
```java
// Pre-order traversal (recursive)
BinaryTree.preOrder(root);

// Pre-order traversal (non-recursive)
BinaryTree.preOrderWOR(root);

// Post-order traversal
BinaryTree.postOrder(root);

// In-order traversal
root.inOrder(root);

// BFS traversal
BinaryTree.bfs(root);
```

### Searching
```java
// Search recursively
boolean found = BinaryTree.searchNode(root, 2);

// Search non-recursively
boolean foundWOR = BinaryTree.searchNodeWOR(root, 2);
```

### Height Calculation
```java
// Height (recursive)
int height = BinaryTree.heightOfTree(root);

// Height (non-recursive)
int heightWOR = BinaryTree.heightOfTreeWOR(root);

```
### Maximum Value
```java

// Maximum value (recursive)
int max = BinaryTree.findMax(root);

// Maximum value (non-recursive)
int maxWOR = BinaryTree.findMaxWOR(root);
```
### Node Count
```java
 // Leaf nodes
int leafNodes = BinaryTree.countLeafNodes(root);

// Full nodes
int fullNodes = BinaryTree.countFullNodes(root);

// Half nodes
int halfNodes = BinaryTree.countHalfNodes(root);
```

### Tree Properties
```java
// Check if two trees are identical
boolean identical = BinaryTree.identicalTrees(root1, root2);

// Find diameter
int diameter = BinaryTree.findDiameter(root);
```
### Path Operations
```java
 // Print all root-to-leaf paths
BinaryTree.printAllRootToLeaf(root);

// Check for a root-to-leaf path with a specified sum
boolean hasPathSum = BinaryTree.hasPathSum(root, 10);
```
### Tree Manipulation
```java
 // Mirror the tree
BinaryTree mirroredTree = BinaryTree.mirrorBinaryTree(root);

// Find the least common ancestor
BinaryTree lca = BinaryTree.leastCommonAncestor(root, node1, node2);
```
