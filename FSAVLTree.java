
import java.util.*;

public class FSAVLTree extends AVLTree<String> {

    /**
     * Create an empty FSAVL tree using a natural comparator
     */
    public FSAVLTree() {
        // super() is implicitly called
    }


    /**
     * Create an FSAVL tree with a specified comparator
     */
    public FSAVLTree(java.util.Comparator<String> c) {
        super(c);
    }

    /**
     * Create an FSAVL tree from an array of objects
     */
    public FSAVLTree(String[] objects) {
        super(objects);
    }
    // i kept getting type errors regarding FSLAVL and AVL so i implemented this to get around it
    @Override
    protected FSAVLTreeNode<String> createNewNode(String fileName) {
        return new FSAVLTreeNode<>(fileName);
    }

    // Override create new node to create an FSAVL Tree Node
    @Override
    protected FSAVLTreeNode<String> FSAVLTreeNode(String fileName) {
        return new FSAVLTreeNode<>(fileName);
    }

    // Search for the file paths that match the given filename string (case-insensitive)
    //TODO:
    // this can include extension or not so make sure to remove it
    public Set<String> searchFile(String fileName) {
        // Remove extension from fileName
        String nodeName = removeExtension(fileName);
        // Find the node corresponding to the file name
        FSAVLTreeNode<String> node = findNode(nodeName);
        // Return file paths if the node exists; otherwise, return an empty set
        return (node != null) ? node.filePaths : new HashSet<>();
    }

    // Search for all file paths that match the given string to any part in file path (case-insensitive)
    //TODO:
    public Set<String> searchAll(String searchString) {
        Set<String> results = new HashSet<>();
        // Start a DFS traversal to search for matching file paths
        preorderDFS((FSAVLTreeNode<String>) getRoot(), searchString.toLowerCase(), results);
        return results;
    }

    //TODO:
    private void preorderDFS(FSAVLTreeNode<String> node, String searchValue, Set<String> results) {
        // check if node is null if not then proceed with root left right
        if (node == null) return;

        // Check if any file path in the node contains the search string
        for (String filePath : node.filePaths) {
            if (filePath.toLowerCase().contains(searchValue)) {
                results.add(filePath);
            }
        }
        // Recur for left and right subtrees
        preorderDFS((FSAVLTreeNode<String>) node.left, searchValue, results);
        preorderDFS((FSAVLTreeNode<String>) node.right, searchValue, results);

        // Add to results set to make it tail-recursive
        // Recursively search in the left and right subtrees
    }

    //TODO:
    public boolean insertFile(String filePath) {
        // Get the file name without extension
        String fileName = getFileNameOf(filePath);
        String nodeName = removeExtension(fileName);

        // Check if a node with this file name already exists
        FSAVLTreeNode<String> node = findNode(nodeName);
        if (node != null) {
            //  System.out.println("node " + nodeName + " found and paths " + filePath + " are being added");
            return node.filePaths.add(filePath); // Add file path to existing node
        }

        // Insert new node if it does not exist
        if (super.insert(nodeName)) {
            //  System.out.println("node " + nodeName + " is being created and paths " + filePath + " has been added");
            node = findNode(nodeName);
            if (node != null) {
                return node.filePaths.add(filePath);
            }
        }
        //  System.out.println("Some error occured");
        return false;
    }

    //TODO:
    public boolean deleteFile(String filePath) {
        // Get the file name and remove its extension
        String fileName = getFileNameOf(filePath);
        String nodeName = removeExtension(fileName);

        // Find the node
        FSAVLTreeNode<String> node = findNode(nodeName);
        if (node == null) return false; // Node not found

        // Remove the file path from the node's set
        if (node.filePaths.remove(filePath)) {
            // If the node has no remaining file paths, remove the node itself
            if (node.filePaths.isEmpty()) {
                return super.delete(nodeName);
            }
            return true;
        }
        return false;
    }

    // Helper method to find a node (case-insensitive) returns node
    //TODO:
    private FSAVLTreeNode<String> findNode(String element) {
        FSAVLTreeNode<String> current = (FSAVLTreeNode<String>) getRoot();

        while (current != null) {
            int comparison = compare(element, (String) current.element);
            if (comparison == 0) return current;
            // less code but still navigates through AVLTree
            current = (comparison < 0) ? (FSAVLTreeNode<String>) current.left : (FSAVLTreeNode<String>) current.right;
        }
        return null; // Node not found
    }

    // Helper method to get the file name from the file path
    private String getFileNameOf(String filePath) {
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }

    // Helper method to remove the extension from the file name
    private static String removeExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(0, lastDotIndex);
        }
        return fileName;
    }

    /**
     * FSAVLTreeNode is AVLTreeNode plus any additional fields we need
     */
    //TODO:
    protected static class FSAVLTreeNode<String> extends AVLTree.AVLTreeNode<String> {
        // the data item in the super-class will be used the store the file name (without extension)
        // FSAVLTreeNode also requires a Set<String> of all matching file paths for that file name
        Set<String> filePaths;

        // Update constructor so that it initializes the set of file paths accordingly
        public FSAVLTreeNode(String fileName) {
            super(fileName); // Calling parent constructor with fileName
            this.filePaths = new HashSet<>(); // Initialize the set (IMPORTANT)

        }

    }
}
