<h2><a href="https://leetcode.com/problems/find-all-duplicates-in-an-array">442. Find All Duplicates in an Array</a></h2><h3>Medium</h3><hr><p>Given an integer array <code>nums</code> of length <code>n</code> where all the integers of <code>nums</code> are in the range <code>[1, n]</code> and each integer appears <strong>once</strong> or <strong>twice</strong>, return <em>an array of all the integers that appears <strong>twice</strong></em>.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and uses only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [2,3]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> [1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> []
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li>Each element in <code>nums</code> appears <strong>once</strong> or <strong>twice</strong>.</li>
</ul>


# Duplicate Finder in Array

This repository contains a Java solution for identifying all integers that appear twice in an array where every integer is within the range [1, n] and each integer appears either once or twice. The solution adheres to the constraints of O(n) time complexity and uses only constant extra space.

## Problem Statement

Given an integer array `nums` of length `n` where all the integers of `nums` are in the range [1, n] and each integer appears once or twice, the task is to return an array of all the integers that appear twice.

## Solution Approach

### Overview

The algorithm utilizes the properties of the array indices in combination with the values of the array to track duplicates efficiently. By marking visited numbers using negation, the solution detects duplicates without needing additional space for storage.

### Detailed Steps

1. **Index Calculation**:
   - For each number in the array, calculate the corresponding index as `index = Math.abs(nums[i]) - 1`.
   
2. **Marking**:
   - Use the value at this index to determine if the number has been encountered before.
   - If the value at this computed index is negative, it implies that the current number is a duplicate.
   - Otherwise, negate the value at this index to mark the number as seen.

3. **Result Compilation**:
   - Traverse the array and collect numbers that have caused a negation in another index, indicating that they appear twice.

