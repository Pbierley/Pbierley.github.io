import java.util.HashSet;
import java.util.Set;

public class TestFSAVLTree {
	public static void main(String[] args) {
		// Create an empty FSAVLTree
		FSAVLTree newFSTree = new FSAVLTree();

		// Run all tests
		int testNum = 0;
		testDeleteFromEmptyTree(++testNum, newFSTree);
		testInsertFile(++testNum, newFSTree);
		testInsertDuplicateFile(++testNum, newFSTree);
		testSearchFileWithoutExtension(++testNum, newFSTree);
		testSearchFileWithExtension(++testNum, newFSTree);
		testDeleteFile(++testNum, newFSTree);
		testInsertMultipleFiles(++testNum, newFSTree);
		testSearchAll(++testNum, newFSTree);
		testInsertDifferentFiles(++testNum, newFSTree);
		testSearchNonExistentFile(++testNum, newFSTree);
		testSearchAllInDocumentsFolder(++testNum, newFSTree);
	}

	private static void testDeleteFromEmptyTree(int testNum, FSAVLTree tree) {
		if (!tree.deleteFile("C:/Users/JohnDoe/Documents/Java/Project1.java")) {
			System.out.println("Test " + testNum + ": Delete from empty tree - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Delete from empty tree - Failed");
		}
	}

	private static void testInsertFile(int testNum, FSAVLTree tree) {
		if (tree.insertFile("C:/Users/JohnDoe/Documents/Java/Project1.java")) {
			System.out.println("Test " + testNum + ": Insert file - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ":Insert file - Failed");
		}
	}

	private static void testInsertDuplicateFile(int testNum, FSAVLTree tree) {
		if (!tree.insertFile("C:/Users/JohnDoe/Documents/Java/Project1.java")) {
			System.out.println("Test " + testNum + ": Insert duplicate file - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Insert duplicate file - Failed");
		}
	}

	private static void testSearchFileWithoutExtension(int testNum, FSAVLTree tree) {
		Set<String> expectedSet = new HashSet<>(Set.of("C:/Users/JohnDoe/Documents/Java/Project1.java"));
		Set<String> resultSet = tree.searchFile("Project1");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Search file without extension - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Search file without extension - Failed");
		}
	}

	private static void testSearchFileWithExtension(int testNum, FSAVLTree tree) {
		Set<String> expectedSet = new HashSet<>(Set.of("C:/Users/JohnDoe/Documents/Java/Project1.java"));
		Set<String> resultSet = tree.searchFile("Project1.java");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Search file with extension - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Search file with extension - Failed");
		}
	}

	private static void testDeleteFile(int testNum, FSAVLTree tree) {
		tree.deleteFile("C:/Users/JohnDoe/Documents/Java/Project1.java");
		if (!tree.searchFile("Project1").contains("C:/Users/JohnDoe/Documents/Java/Project1.java")
				&& !tree.searchFile("Project1.java").contains("C:/Users/JohnDoe/Documents/Java/Project1.java")) {
			System.out.println("Test " + testNum + ": Delete file - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Delete file - Failed");
		}
	}

	private static void testInsertMultipleFiles(int testNum, FSAVLTree tree) {
		tree.insertFile("C:/Users/JohnDoe/Documents/Java/Project1.txt");
		tree.insertFile("D:/Users/JohnDoe/Documents/Java/Project1.txt");
		tree.insertFile("C:/Users/JohnDoe/Project1.java");
		tree.insertFile("C:/Users/JohnDoe/Project1.txt");
		tree.insertFile("D:/Users/Project1.jpeg");

		Set<String> expectedSet = new HashSet<>(
				Set.of("C:/Users/JohnDoe/Documents/Java/Project1.txt", "D:/Users/JohnDoe/Documents/Java/Project1.txt",
						"C:/Users/JohnDoe/Project1.java", "C:/Users/JohnDoe/Project1.txt", "D:/Users/Project1.jpeg"));

		Set<String> resultSet = tree.searchFile("Project1");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Insert multiple files - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Insert multiple files - Failed");
		}
	}

	private static void testSearchAll(int testNum, FSAVLTree tree) {
		Set<String> expectedSet = new HashSet<>(
				Set.of("C:/Users/JohnDoe/Documents/Java/Project1.txt", "D:/Users/JohnDoe/Documents/Java/Project1.txt",
						"C:/Users/JohnDoe/Project1.java", "C:/Users/JohnDoe/Project1.txt"));

		Set<String> resultSet = tree.searchAll("JohnDoe");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Search all - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Search all - Failed");
		}
	}

	private static void testInsertDifferentFiles(int testNum, FSAVLTree tree) {
		tree.insertFile("C:/Users/JohnDoe/Documents/Clion/Project2.c");
		tree.insertFile("C:/Users/JohnDoe/Clion/Project2.cpp");
		tree.insertFile("C:/Users/JohnDoe/Documents/Java/Utils/Helper.java");
		tree.insertFile("C:/Users/JohnDoe/Desktop/Backup/Archive.zip");
		tree.insertFile("C:/Users/JohnDoe/Desktop/Backup/Photos/Vacation.jpg");
		tree.insertFile("C:/Users/JohnDoe/Downloads/README.md");
		tree.insertFile("C:/Users/JohnDoe/Documents/README.pdf");
		tree.insertFile("C:/Users/JohnDoe/Music/Playlist/TopHits.mp3");

		Set<String> expectedSet = new HashSet<>(
				Set.of("C:/Users/JohnDoe/Documents/Clion/Project2.c", "C:/Users/JohnDoe/Clion/Project2.cpp"));

		Set<String> resultSet = tree.searchFile("Project2");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Insert different files - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Insert different files - Failed");
		}
	}

	private static void testSearchNonExistentFile(int testNum, FSAVLTree tree) {
		Set<String> resultSet = tree.searchFile("NonExistentFile");
		if (resultSet.isEmpty()) {
			System.out.println("Test " + testNum + ": Search non-existent file - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Search non-existent file - Failed");
		}
	}

	private static void testSearchAllInDocumentsFolder(int testNum, FSAVLTree tree) {
		// Items below were inserted previously in testSearchAll and testInsertDifferentFiles methods
		Set<String> expectedSet = new HashSet<>(Set.of("C:/Users/JohnDoe/Documents/Java/Project1.txt",
				"D:/Users/JohnDoe/Documents/Java/Project1.txt", "C:/Users/JohnDoe/Documents/Clion/Project2.c",
				"C:/Users/JohnDoe/Documents/Java/Utils/Helper.java", "C:/Users/JohnDoe/Documents/README.pdf"

		));
		Set<String> resultSet = tree.searchAll("documents");
		if (resultSet.equals(expectedSet)) {
			System.out.println("Test " + testNum + ": Search all in documents folder - Passed");
		} else {
			throw new RuntimeException("Test " + testNum + ": Search all in documents folder - Failed");
		}
	}
}