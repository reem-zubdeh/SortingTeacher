import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.CardLayout;
import javax.swing.JEditorPane;

public class SortingTeacherGUI implements ActionListener, ChangeListener {

	// ************************************************
	// *************SortingTeacher Project*************
	// ***************GUI - Main Program***************
	// ************************************************

	// *************Field variables*************
	JFrame frame;
	JPanel MainPanel;
	JRadioButton rb;
	Graphics g;
	Graphics2D g2d;
	Color transparent;
	Color color1;
	Color color2;
	Color color3;
	Color color4;
	JPanel WelcomePanel;
	JTextField txtSelectOneOf;
	JTextField bucketTextField;
	JTextField arrayTextField;
	JTextField txtArrayElementsSeparated;
	JTextField txtNumberOfBuckets;
	ButtonGroup group;
	JRadioButton mergeSortRadioButton;
	JRadioButton bubbleSortRadioButton;
	JRadioButton bucketSortRadioButton;
	JRadioButton heapSortRadioButton;
	JRadioButton insertionSortRadioButton;
	JRadioButton quickSortRadioButton;
	JRadioButton countingSortRadioButton;
	JRadioButton selectionSortRadioButton;
	JButton runButton;
	CardLayout cl;

	JPanel BubblePanel;
	JEditorPane bubblePane;
	JTextField bubbleComment;
	JButton bubbleReturnButton;

	JPanel SelectionPanel;
	JEditorPane selectionPane;
	JTextField selectionComment;
	JButton selectionReturnButton;

	JPanel InsertionPanel;
	JEditorPane insertionPane;
	JTextField insertionComment;
	JButton insertionReturnButton;

	JPanel MergePanel;
	JEditorPane mergeArray;
	JEditorPane mergeSubArrays;
	JEditorPane mergeMergedArrays;
	JTextField mergeText1;
	JTextField mergeText2;
	JTextField mergeComment;
	JTextField mergeComment2;
	JTextField mergeComment3;
	JButton mergeReturnButton;

	JPanel QuickPanel;
	JEditorPane quickArr;
	JTextField quickText1;
	JEditorPane quickPart;
	JTextField quickText2;
	JTextField quickPivot;
	JTextField quickComment;
	JButton quickReturnButton;

	JPanel HeapPanel;
	JTextField heapComment;
	JTextField heapText1;
	JTextField heapText2;
	JEditorPane heapArr;
	JEditorPane heapTree;
	JTextField heapCurrent;
	JButton heapReturnButton;

	JPanel BucketPanel;
	JEditorPane arraySorting;
	JTextArea bucketSorting;
	JTextField bucketComment;
	JButton bucketReturnButton;

	JPanel CountingPanel;
	JEditorPane arrPane;
	JEditorPane countingArrPane;
	JTextField countingComment;
	JTextField countingComment2;
	JTextField countingComment3;
	JButton countingReturnButton;

	public SortingTeacherGUI() {

		// *************Create the frame*************
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		// *************Initialize some colors*************
		transparent = new Color(0, 0, 0, 0);
		color1 = new Color(77, 115, 227); // ribbons: light green
		color2 = new Color(77, 115, 227); // light blue
		color3 = new Color(40, 113, 209); // gradient 1: blue
		color4 = new Color(30, 178, 201); // gradient 2: greenish blue

		// *************Create the main panel*************
		MainPanel = new JPanel();
		frame.getContentPane().add(MainPanel, BorderLayout.CENTER);

		MainPanel.setPreferredSize(new Dimension(500, 400));
		cl = new CardLayout(0, 0);
		MainPanel.setLayout(cl);

		// *************Create the welcome panel*************
		WelcomePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 0, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(WelcomePanel, "welcomePanel");
		WelcomePanel.setLayout(null);

		// *************Welcome panel: Create the run button*************
		runButton = new JButton("Run");
		runButton.setBounds(246, 343, 89, 23);
		WelcomePanel.add(runButton);
		runButton.addActionListener(this);

		// *************Welcome panel: Create the welcome message*************
		txtSelectOneOf = new JTextField();
		txtSelectOneOf.setForeground(Color.WHITE);
		txtSelectOneOf.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectOneOf.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSelectOneOf.setText("Select one of the following algorithms and add your desired input");
		txtSelectOneOf.setEditable(false);
		txtSelectOneOf.setBounds(0, 39, 596, 52);
		txtSelectOneOf.setBorder(BorderFactory.createEmptyBorder());
		txtSelectOneOf.setBackground(color1);
		WelcomePanel.add(txtSelectOneOf);
		txtSelectOneOf.setColumns(10);

		// *************Welcome panel: Create the array input area*************
		arrayTextField = new JTextField();
		arrayTextField.setBounds(178, 183, 225, 20);
		WelcomePanel.add(arrayTextField);
		arrayTextField.setColumns(10);

		// *************Welcome panel: Create the bucket input area*************
		bucketTextField = new JTextField();
		bucketTextField.setEnabled(false);
		bucketTextField.setBounds(178, 280, 225, 20);
		WelcomePanel.add(bucketTextField);
		bucketTextField.setColumns(10);
		bucketTextField.setVisible(false);

		// *************Welcome panel: Create the array input message*************
		txtArrayElementsSeparated = new JTextField();
		txtArrayElementsSeparated.setForeground(Color.WHITE);
		txtArrayElementsSeparated.setHorizontalAlignment(SwingConstants.CENTER);
		txtArrayElementsSeparated.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtArrayElementsSeparated.setEditable(false);
		txtArrayElementsSeparated.setText("Array Elements (separated by spaces)");
		txtArrayElementsSeparated.setBounds(178, 152, 225, 20);
		txtArrayElementsSeparated.setBorder(BorderFactory.createEmptyBorder());
		txtArrayElementsSeparated.setBackground(color1);
		WelcomePanel.add(txtArrayElementsSeparated);
		txtArrayElementsSeparated.setColumns(10);

		// *************Welcome panel: Create the bucket input message*************
		txtNumberOfBuckets = new JTextField();
		txtNumberOfBuckets.setForeground(Color.WHITE);
		txtNumberOfBuckets.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumberOfBuckets.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumberOfBuckets.setText("Number of Buckets");
		txtNumberOfBuckets.setEditable(false);
		txtNumberOfBuckets.setBounds(178, 249, 225, 20);
		txtNumberOfBuckets.setBorder(BorderFactory.createEmptyBorder());
		txtNumberOfBuckets.setBackground(color1);
		WelcomePanel.add(txtNumberOfBuckets);
		txtNumberOfBuckets.setColumns(10);
		txtNumberOfBuckets.setVisible(false);

		// *************Welcome panel: Create the buttons panel*************
		JPanel ButtonsPanel = new JPanel();
		ButtonsPanel.setBounds(0, 410, 596, 100);
		ButtonsPanel.setBorder(BorderFactory.createEmptyBorder());
		ButtonsPanel.setBackground(color1);
		ButtonsPanel.setPreferredSize(new Dimension(400, 100));
		ButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		WelcomePanel.add(ButtonsPanel);

		// *************Welcome panel: Create the radio buttons for each
		// algorithm*************

		group = new ButtonGroup();

		bubbleSortRadioButton = new JRadioButton("Bubble Sort");
		bubbleSortRadioButton.setForeground(Color.WHITE);
		bubbleSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bubbleSortRadioButton.setBackground(color1);
		ButtonsPanel.add(bubbleSortRadioButton);
		group.add(bubbleSortRadioButton);
		bubbleSortRadioButton.addChangeListener(this);

		selectionSortRadioButton = new JRadioButton("Selection Sort");
		selectionSortRadioButton.setForeground(Color.WHITE);
		selectionSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		selectionSortRadioButton.setBackground(color1);
		ButtonsPanel.add(selectionSortRadioButton);
		group.add(selectionSortRadioButton);
		selectionSortRadioButton.addChangeListener(this);

		insertionSortRadioButton = new JRadioButton("Insertion Sort");
		insertionSortRadioButton.setForeground(Color.WHITE);
		insertionSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertionSortRadioButton.setBackground(color1);
		ButtonsPanel.add(insertionSortRadioButton);
		group.add(insertionSortRadioButton);
		insertionSortRadioButton.addChangeListener(this);

		mergeSortRadioButton = new JRadioButton("Merge Sort");
		mergeSortRadioButton.setForeground(Color.WHITE);
		mergeSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mergeSortRadioButton.setBackground(color1);
		ButtonsPanel.add(mergeSortRadioButton);
		group.add(mergeSortRadioButton);
		mergeSortRadioButton.addChangeListener(this);

		quickSortRadioButton = new JRadioButton("Quick Sort");
		quickSortRadioButton.setForeground(Color.WHITE);
		quickSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quickSortRadioButton.setBackground(color1);
		ButtonsPanel.add(quickSortRadioButton);
		group.add(quickSortRadioButton);
		quickSortRadioButton.addChangeListener(this);

		heapSortRadioButton = new JRadioButton("Heap Sort");
		heapSortRadioButton.setForeground(Color.WHITE);
		heapSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heapSortRadioButton.setBackground(color1);
		ButtonsPanel.add(heapSortRadioButton);
		heapSortRadioButton.addChangeListener(this);

		bucketSortRadioButton = new JRadioButton("Bucket Sort");
		bucketSortRadioButton.setForeground(Color.WHITE);
		bucketSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bucketSortRadioButton.setBackground(color1);
		ButtonsPanel.add(bucketSortRadioButton);
		group.add(heapSortRadioButton);
		bucketSortRadioButton.addChangeListener(this);

		countingSortRadioButton = new JRadioButton("Counting Sort");
		countingSortRadioButton.setForeground(Color.WHITE);
		countingSortRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		countingSortRadioButton.setBackground(color1);
		ButtonsPanel.add(countingSortRadioButton);
		group.add(countingSortRadioButton);
		countingSortRadioButton.addChangeListener(this);
		group.add(bucketSortRadioButton);

		// *************Create bubble sort panel*************
		BubblePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(BubblePanel, "bubblePanel");
		BubblePanel.setLayout(null);

		// *************Bubble panel component*************
		bubblePane = new JEditorPane();
		bubblePane.setEditable(false);
		bubblePane.setContentType("text/html");
		bubblePane.setBounds(0, 137, 596, 88);
		bubblePane.setBorder(BorderFactory.createEmptyBorder());
		bubblePane.setBackground(color1);
		BubblePanel.add(bubblePane);

		// *************Bubble panel component*************
		bubbleComment = new JTextField();
		bubbleComment.setForeground(Color.WHITE);
		bubbleComment.setHorizontalAlignment(SwingConstants.CENTER);
		bubbleComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		bubbleComment.setEditable(false);
		bubbleComment.setColumns(10);
		bubbleComment.setBorder(BorderFactory.createEmptyBorder());
		bubbleComment.setBackground(new Color(77, 115, 227));
		bubbleComment.setBounds(0, 290, 596, 52);
		BubblePanel.add(bubbleComment);

		// *************Bubble panel component*************
		bubbleReturnButton = new JButton("Return");
		bubbleReturnButton.setBounds(462, 514, 89, 23);
		bubbleReturnButton.addActionListener(this);
		BubblePanel.add(bubbleReturnButton);

		// *************Create selection sort panel*************
		SelectionPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(SelectionPanel, "selectionPanel");
		SelectionPanel.setLayout(null);

		// *************Selection panel component*************
		selectionPane = new JEditorPane();
		selectionPane.setEditable(false);
		selectionPane.setContentType("text/html");
		selectionPane.setBorder(BorderFactory.createEmptyBorder());
		selectionPane.setBackground(new Color(77, 115, 227));
		selectionPane.setBounds(0, 137, 596, 88);
		SelectionPanel.add(selectionPane);

		// *************Selection panel component*************
		selectionComment = new JTextField();
		selectionComment.setForeground(Color.WHITE);
		selectionComment.setHorizontalAlignment(SwingConstants.CENTER);
		selectionComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		selectionComment.setEditable(false);
		selectionComment.setColumns(10);
		selectionComment.setBorder(BorderFactory.createEmptyBorder());
		selectionComment.setBackground(new Color(77, 115, 227));
		selectionComment.setBounds(0, 290, 596, 52);
		SelectionPanel.add(selectionComment);

		// *************Selection panel component*************
		selectionReturnButton = new JButton("Return");
		selectionReturnButton.setBounds(462, 514, 89, 23);
		selectionReturnButton.addActionListener(this);
		SelectionPanel.add(selectionReturnButton);

		// *************Create insertion sort panel*************
		InsertionPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(InsertionPanel, "insertionPanel");
		InsertionPanel.setLayout(null);

		// *************Insertion panel component*************
		insertionPane = new JEditorPane();
		insertionPane.setEditable(false);
		insertionPane.setContentType("text/html");
		insertionPane.setBorder(BorderFactory.createEmptyBorder());
		insertionPane.setBackground(new Color(77, 115, 227));
		insertionPane.setBounds(0, 137, 596, 88);
		InsertionPanel.add(insertionPane);

		// *************Insertion panel component*************
		insertionComment = new JTextField();
		insertionComment.setForeground(Color.WHITE);
		insertionComment.setHorizontalAlignment(SwingConstants.CENTER);
		insertionComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		insertionComment.setEditable(false);
		insertionComment.setColumns(10);
		insertionComment.setBorder(BorderFactory.createEmptyBorder());
		insertionComment.setBackground(new Color(77, 115, 227));
		insertionComment.setBounds(0, 290, 596, 52);
		InsertionPanel.add(insertionComment);

		// *************Insertion panel component*************
		insertionReturnButton = new JButton("Return");
		insertionReturnButton.setBounds(462, 514, 89, 23);
		insertionReturnButton.addActionListener(this);
		InsertionPanel.add(insertionReturnButton);

		// *************Create merge sort panel*************
		MergePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(MergePanel, "mergePanel");
		MergePanel.setLayout(null);

		// *************Merge panel component*************
		mergeArray = new JEditorPane();
		mergeArray.setEditable(false);
		mergeArray.setContentType("text/html");
		mergeArray.setBorder(BorderFactory.createEmptyBorder());
		mergeArray.setBackground(new Color(77, 115, 227));
		mergeArray.setBounds(0, 51, 596, 88);
		MergePanel.add(mergeArray);

		// *************Merge panel component*************
		mergeSubArrays = new JEditorPane();
		mergeSubArrays.setEditable(false);
		mergeSubArrays.setContentType("text/html");
		mergeSubArrays.setBorder(BorderFactory.createEmptyBorder());
		mergeSubArrays.setBackground(new Color(77, 115, 227));
		mergeSubArrays.setBounds(33, 252, 183, 88);
		MergePanel.add(mergeSubArrays);

		// *************Merge panel component*************
		mergeMergedArrays = new JEditorPane();
		mergeMergedArrays.setEditable(false);
		mergeMergedArrays.setContentType("text/html");
		mergeMergedArrays.setBorder(BorderFactory.createEmptyBorder());
		mergeMergedArrays.setBackground(new Color(77, 115, 227));
		mergeMergedArrays.setBounds(257, 252, 295, 88);
		MergePanel.add(mergeMergedArrays);

		// *************Merge panel component*************
		mergeText1 = new JTextField();
		mergeText1.setForeground(Color.WHITE);
		mergeText1.setText("Subarrays:");
		mergeText1.setHorizontalAlignment(SwingConstants.CENTER);
		mergeText1.setFont(new Font("Tahoma", Font.BOLD, 16));
		mergeText1.setEditable(false);
		mergeText1.setColumns(10);
		mergeText1.setBorder(BorderFactory.createEmptyBorder());
		mergeText1.setBackground(new Color(77, 115, 227));
		mergeText1.setBounds(33, 209, 183, 43);
		MergePanel.add(mergeText1);

		// *************Merge panel component*************
		mergeText2 = new JTextField();
		mergeText2.setForeground(Color.WHITE);
		mergeText2.setText("Merged arrays:");
		mergeText2.setHorizontalAlignment(SwingConstants.CENTER);
		mergeText2.setFont(new Font("Tahoma", Font.BOLD, 16));
		mergeText2.setEditable(false);
		mergeText2.setColumns(10);
		mergeText2.setBorder(BorderFactory.createEmptyBorder());
		mergeText2.setBackground(new Color(77, 115, 227));
		mergeText2.setBounds(257, 209, 295, 43);
		MergePanel.add(mergeText2);

		// *************Merge panel component*************
		mergeComment = new JTextField();
		mergeComment.setHorizontalAlignment(SwingConstants.CENTER);
		mergeComment.setForeground(Color.WHITE);
		mergeComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		mergeComment.setEditable(false);
		mergeComment.setColumns(10);
		mergeComment.setBorder(BorderFactory.createEmptyBorder());
		mergeComment.setBackground(new Color(77, 115, 227));
		mergeComment.setBounds(0, 408, 596, 20);
		MergePanel.add(mergeComment);

		// *************Merge panel component*************
		mergeComment2 = new JTextField();
		mergeComment2.setHorizontalAlignment(SwingConstants.CENTER);
		mergeComment2.setForeground(Color.WHITE);
		mergeComment2.setFont(new Font("Tahoma", Font.BOLD, 16));
		mergeComment2.setEditable(false);
		mergeComment2.setColumns(10);
		mergeComment2.setBorder(BorderFactory.createEmptyBorder());
		mergeComment2.setBackground(new Color(77, 115, 227));
		mergeComment2.setBounds(0, 428, 596, 20);
		MergePanel.add(mergeComment2);

		// *************Merge panel component*************
		mergeComment3 = new JTextField();
		mergeComment3.setHorizontalAlignment(SwingConstants.CENTER);
		mergeComment3.setForeground(Color.WHITE);
		mergeComment3.setFont(new Font("Tahoma", Font.BOLD, 16));
		mergeComment3.setEditable(false);
		mergeComment3.setColumns(10);
		mergeComment3.setBorder(BorderFactory.createEmptyBorder());
		mergeComment3.setBackground(new Color(77, 115, 227));
		mergeComment3.setBounds(0, 448, 596, 20);
		MergePanel.add(mergeComment3);

		// *************Merge panel component*************
		mergeReturnButton = new JButton("Return");
		mergeReturnButton.setBounds(462, 514, 89, 23);
		mergeReturnButton.addActionListener(this);
		MergePanel.add(mergeReturnButton);

		// *************Create quick sort panel*************
		QuickPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(QuickPanel, "quickPanel");
		QuickPanel.setLayout(null);

		// *************Quick panel component*************
		quickArr = new JEditorPane();
		quickArr.setEditable(false);
		quickArr.setContentType("text/html");
		quickArr.setBorder(BorderFactory.createEmptyBorder());
		quickArr.setBackground(new Color(77, 115, 227));
		quickArr.setBounds(0, 35, 596, 88);
		QuickPanel.add(quickArr);

		// *************Quick panel component*************
		quickText1 = new JTextField();
		quickText1.setText("Current partition:");
		quickText1.setHorizontalAlignment(SwingConstants.CENTER);
		quickText1.setForeground(Color.WHITE);
		quickText1.setFont(new Font("Tahoma", Font.BOLD, 16));
		quickText1.setEditable(false);
		quickText1.setColumns(10);
		quickText1.setBorder(BorderFactory.createEmptyBorder());
		quickText1.setBackground(new Color(77, 115, 227));
		quickText1.setBounds(37, 164, 333, 43);
		QuickPanel.add(quickText1);

		// *************Quick panel component*************
		quickPart = new JEditorPane();
		quickPart.setEditable(false);
		quickPart.setContentType("text/html");
		quickPart.setBorder(BorderFactory.createEmptyBorder());
		quickPart.setBackground(new Color(77, 115, 227));
		quickPart.setBounds(37, 207, 333, 115);
		QuickPanel.add(quickPart);

		// *************Quick panel component*************
		quickText2 = new JTextField();
		quickText2.setText("Pivot:");
		quickText2.setHorizontalAlignment(SwingConstants.CENTER);
		quickText2.setForeground(Color.WHITE);
		quickText2.setFont(new Font("Tahoma", Font.BOLD, 16));
		quickText2.setEditable(false);
		quickText2.setColumns(10);
		quickText2.setBorder(BorderFactory.createEmptyBorder());
		quickText2.setBackground(new Color(77, 115, 227));
		quickText2.setBounds(447, 164, 80, 43);
		QuickPanel.add(quickText2);

		// *************Quick panel component*************
		quickPivot = new JTextField();
		quickPivot.setHorizontalAlignment(SwingConstants.CENTER);
		quickPivot.setForeground(Color.WHITE);
		quickPivot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quickPivot.setEditable(false);
		quickPivot.setBorder(BorderFactory.createEmptyBorder());
		quickPivot.setBackground(new Color(77, 115, 227));
		quickPivot.setBounds(447, 207, 80, 52);
		QuickPanel.add(quickPivot);

		// *************Quick panel component*************
		quickComment = new JTextField();
		quickComment.setHorizontalAlignment(SwingConstants.CENTER);
		quickComment.setForeground(Color.WHITE);
		quickComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		quickComment.setEditable(false);
		quickComment.setColumns(10);
		quickComment.setBorder(BorderFactory.createEmptyBorder());
		quickComment.setBackground(new Color(77, 115, 227));
		quickComment.setBounds(0, 426, 596, 52);
		QuickPanel.add(quickComment);

		// *************Quick panel component*************
		quickReturnButton = new JButton();
		quickReturnButton.setText("Return");
		quickReturnButton.setBounds(462, 514, 89, 23);
		quickReturnButton.addActionListener(this);
		QuickPanel.add(quickReturnButton);

		// *************Create heap sort panel*************
		HeapPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(HeapPanel, "heapPanel");
		HeapPanel.setLayout(null);

		// *************Heap panel component*************
		heapComment = new JTextField();
		heapComment.setHorizontalAlignment(SwingConstants.CENTER);
		heapComment.setForeground(Color.WHITE);
		heapComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		heapComment.setEditable(false);
		heapComment.setColumns(10);
		heapComment.setBorder(BorderFactory.createEmptyBorder());
		heapComment.setBackground(new Color(77, 115, 227));
		heapComment.setBounds(0, 426, 596, 52);
		HeapPanel.add(heapComment);

		// *************Heap panel component*************
		heapArr = new JEditorPane();
		heapArr.setEditable(false);
		heapArr.setContentType("text/html");
		heapArr.setBorder(BorderFactory.createEmptyBorder());
		heapArr.setBackground(new Color(77, 115, 227));
		heapArr.setBounds(0, 35, 596, 88);
		HeapPanel.add(heapArr);

		// *************Heap panel component*************
		heapTree = new JEditorPane();
		heapTree.setEditable(false);
		heapTree.setContentType("text/html");
		heapTree.setBorder(BorderFactory.createEmptyBorder());
		heapTree.setBackground(new Color(77, 115, 227));
		heapTree.setBounds(37, 207, 368, 190);
		HeapPanel.add(heapTree);

		// *************Heap panel component*************
		heapText1 = new JTextField();
		heapText1.setText("Binary heap:");
		heapText1.setHorizontalAlignment(SwingConstants.CENTER);
		heapText1.setForeground(Color.WHITE);
		heapText1.setFont(new Font("Tahoma", Font.BOLD, 16));
		heapText1.setEditable(false);
		heapText1.setColumns(10);
		heapText1.setBorder(BorderFactory.createEmptyBorder());
		heapText1.setBackground(new Color(77, 115, 227));
		heapText1.setBounds(37, 164, 368, 43);
		HeapPanel.add(heapText1);

		// *************Heap panel component*************
		heapCurrent = new JTextField();
		heapCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		heapText1.setHorizontalAlignment(SwingConstants.CENTER);
		heapCurrent.setForeground(Color.WHITE);
		heapCurrent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heapCurrent.setEditable(false);
		heapText1.setColumns(1);
		heapCurrent.setBorder(BorderFactory.createEmptyBorder());
		heapCurrent.setBackground(new Color(77, 115, 227));
		heapCurrent.setBounds(476, 207, 80, 52);
		HeapPanel.add(heapCurrent);

		// *************Heap panel component*************
		heapText2 = new JTextField();
		heapText2.setText("Current:");
		heapText2.setHorizontalAlignment(SwingConstants.CENTER);
		heapText2.setForeground(Color.WHITE);
		heapText2.setFont(new Font("Tahoma", Font.BOLD, 16));
		heapText2.setEditable(false);
		heapText2.setColumns(10);
		heapText2.setBorder(BorderFactory.createEmptyBorder());
		heapText2.setBackground(new Color(77, 115, 227));
		heapText2.setBounds(476, 164, 80, 43);
		HeapPanel.add(heapText2);

		// *************Heap panel component*************
		heapReturnButton = new JButton("Return");
		heapReturnButton.setBounds(462, 514, 89, 23);
		heapReturnButton.addActionListener(this);
		HeapPanel.add(heapReturnButton);

		// *************Create bucket sort panel*************
		BucketPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(BucketPanel, "bucketPanel");
		BucketPanel.setLayout(null);

		// *************Bucket panel component*************
		arraySorting = new JEditorPane();
		arraySorting.setEditable(false);
		arraySorting.setBounds(0, 36, 596, 88);
		arraySorting.setContentType("text/html");
		arraySorting.setBorder(BorderFactory.createEmptyBorder());
		arraySorting.setBackground(color1);
		BucketPanel.add(arraySorting);

		// *************Bucket panel component*************
		bucketSorting = new JTextArea();
		bucketSorting.setForeground(Color.WHITE);
		bucketSorting.setFont(new Font("Tahoma", Font.PLAIN, 21));
		bucketSorting.setBackground(color1);
		bucketSorting.setEditable(false);
		bucketSorting.setBounds(126, 155, 340, 217);
		bucketSorting.setBorder(BorderFactory.createEmptyBorder());
		BucketPanel.add(bucketSorting);

		// *************Bucket panel component*************
		bucketComment = new JTextField();
		bucketComment.setForeground(Color.WHITE);
		bucketComment.setHorizontalAlignment(SwingConstants.CENTER);
		bucketComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		bucketComment.setEditable(false);
		bucketComment.setColumns(10);
		bucketComment.setBounds(0, 426, 596, 52);
		bucketComment.setBorder(BorderFactory.createEmptyBorder());
		bucketComment.setBackground(color1);
		BucketPanel.add(bucketComment);

		// *************Bucket panel component*************
		bucketReturnButton = new JButton("Return");
		bucketReturnButton.setBounds(462, 514, 89, 23);
		bucketReturnButton.addActionListener(this);
		BucketPanel.add(bucketReturnButton);

		// *************Create counting sort panel*************
		CountingPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gp = new GradientPaint(0, 0, color3, 180, height, color4);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, width, height);
			}
		};
		MainPanel.add(CountingPanel, "countingPanel");
		CountingPanel.setLayout(null);

		// *************Counting panel component*************
		arrPane = new JEditorPane();
		arrPane.setEditable(false);
		arrPane.setContentType("text/html");
		arrPane.setBackground(color1);
		arrPane.setBounds(0, 38, 596, 88);
		arrPane.setBorder(BorderFactory.createEmptyBorder());
		CountingPanel.add(arrPane);

		// *************Counting panel component*************
		countingArrPane = new JEditorPane();
		countingArrPane.setContentType("text/html");
		countingArrPane.setEditable(false);
		countingArrPane.setBounds(103, 155, 390, 165);
		countingArrPane.setBorder(BorderFactory.createEmptyBorder());
		countingArrPane.setBackground(color1);
		CountingPanel.add(countingArrPane);

		// *************Counting panel component*************
		countingComment = new JTextField();
		countingComment.setForeground(Color.WHITE);
		countingComment.setHorizontalAlignment(SwingConstants.CENTER);
		countingComment.setFont(new Font("Tahoma", Font.BOLD, 16));
		countingComment.setEditable(false);
		countingComment.setColumns(10);
		countingComment.setBorder(BorderFactory.createEmptyBorder());
		countingComment.setBackground(new Color(77, 115, 227));
		countingComment.setBounds(0, 390, 596, 20);
		CountingPanel.add(countingComment);

		// *************Counting panel component*************
		countingComment2 = new JTextField();
		countingComment2.setHorizontalAlignment(SwingConstants.CENTER);
		countingComment2.setForeground(Color.WHITE);
		countingComment2.setFont(new Font("Tahoma", Font.BOLD, 16));
		countingComment2.setEditable(false);
		countingComment2.setColumns(10);
		countingComment2.setBorder(BorderFactory.createEmptyBorder());
		countingComment2.setBackground(new Color(77, 115, 227));
		countingComment2.setBounds(0, 410, 596, 20);
		CountingPanel.add(countingComment2);

		// *************Counting panel component*************
		countingComment3 = new JTextField();
		countingComment3.setHorizontalAlignment(SwingConstants.CENTER);
		countingComment3.setForeground(Color.WHITE);
		countingComment3.setFont(new Font("Tahoma", Font.BOLD, 16));
		countingComment3.setEditable(false);
		countingComment3.setColumns(10);
		countingComment3.setBorder(BorderFactory.createEmptyBorder());
		countingComment3.setBackground(new Color(77, 115, 227));
		countingComment3.setBounds(0, 430, 596, 20);
		CountingPanel.add(countingComment3);

		// *************Counting panel component*************
		countingReturnButton = new JButton("Return");
		countingReturnButton.setBounds(462, 514, 89, 23);
		countingReturnButton.addActionListener(this);
		CountingPanel.add(countingReturnButton);

		frame.setVisible(true);

	}

	public static void main(String[] args) {

		// executable main method: call the constructor and start the GUI
		new SortingTeacherGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int bucket = 0;
		int[] arr = {0};
		
		// *************If the source of the event was the return button restart program*************
		if (!e.getSource().equals(runButton)) {
			frame.dispose();
			new SortingTeacherGUI();
		}

		// *************Handle empty input*************
		if (group.getSelection() == null)
			return;

		if (arrayTextField.getText().length() == 0)
			return;
		
		// *************Handle bad input in the array field*************
		try {
		 arr = parseInputArr(arrayTextField.getText());
		}catch(NumberFormatException err) {
			
			JOptionPane.showMessageDialog(WelcomePanel,"Bad Input: array should only include integers","Error",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// *************Run bubble sort simulation*************
		if (bubbleSortRadioButton.isSelected()) {

			cl.show(MainPanel, "bubblePanel");
			BubbleSort bubble = new BubbleSort(arr);
			bubble.sort();

			Thread bubbleThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {
						while (count < bubble.arrayDis.size()) {

							Thread.sleep(1500);

							bubbleComment.setText(bubble.comment.get(count));
							bubblePane.setText(bubble.arrayDis.get(count));
							count++;

						}
						bubbleComment.setText(bubble.comment.get(count));
					} catch (InterruptedException e) {
					}
				}
			});

			bubbleThread.start();
		}

		// *************Run selection sort simulation*************
		if (selectionSortRadioButton.isSelected()) {

			cl.show(MainPanel, "selectionPanel");
			SelectionSort selly = new SelectionSort(arr);
			selly.sort();

			Thread selectionThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {
						while (count < selly.arrayDis.size()) {

							Thread.sleep(1500);

							selectionComment.setText(selly.comment.get(count));
							selectionPane.setText(selly.arrayDis.get(count));
							count++;

						}
						selectionComment.setText("Array sorted");
					} catch (InterruptedException e) {
					}
				}
			});

			selectionThread.start();
		}

		// *************Run insertion sort simulation*************
		if (insertionSortRadioButton.isSelected()) {

			cl.show(MainPanel, "insertionPanel");
			InsertionSort ins = new InsertionSort(arr);
			ins.sort();

			Thread insertionThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {
						while (count < ins.array.size()) {

							Thread.sleep(1500);

							insertionComment.setText(ins.comment.get(count));
							insertionPane.setText(ins.array.get(count));
							count++;

						}
						selectionComment.setText("Array sorted");
					} catch (InterruptedException e) {
					}
				}
			});

			insertionThread.start();
		}

		// *************Run merge sort simulation*************
		if (mergeSortRadioButton.isSelected()) {

			cl.show(MainPanel, "mergePanel");

			MergeSort ms = new MergeSort(arr);

			mergeArray.setText(Formatter.htmlString(arr));

			ms.sort(arr);

			Thread mergeThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {

						mergeComment.setText("Recursively split the array into two. ");
						mergeComment2.setText("Recursively merge the two subarrays");
						mergeComment3.setText("into a larger array in order.");

						while (count < ms.arr.size()) {

							mergeArray.setText(ms.arr.get(count));

							Thread.sleep(1500);

							mergeSubArrays.setText(
									"<p style=\"font-size:100%;font-family:Tahoma; text-align:center; color: white\">"
											+ "Subarray 1: " + ms.subArrL.get(count) + "</p>" + "\n"
											+ "<p style=\"font-size:100%;font-family:Tahoma; text-align:center; color: white\">"
											+ "Subarray 2: " + ms.subArrR.get(count) + "</p>");

							mergeMergedArrays.setText(
									"<div style=\"font-size:65%;font-family:Tahoma; text-align:center; color: white\">"
											+ ms.mergedArr.get(count) + "</div>");

							count++;

						}

						mergeComment.setText("");
						mergeComment2.setText("Array sorted");
						mergeComment3.setText("");

					} catch (InterruptedException e) {
					}
				}
			});

			mergeThread.start();

		}

		// *************Run quick sort simulation*************
		if (quickSortRadioButton.isSelected()) {

			cl.show(MainPanel, "quickPanel");

			QuickSort qs = new QuickSort(arr);

			qs.sort();

			Thread quickThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {

						quickArr.setText(qs.array.get(count));
						quickComment.setText(qs.comment.get(count));

						while (count < qs.array.size()) {

							Thread.sleep(2000);

							quickArr.setText(qs.array.get(count));
							quickPart.setText(
									"<div style=\"font-size:70%;font-family:Tahoma; text-align:center; color: white\">"
											+ qs.part.get(count) + "</div>");
							quickPivot.setText(qs.piv.get(count));
							quickComment.setText(qs.comment.get(count));

							count++;

						}

						quickPart.setText("");
						quickPivot.setText("");
						quickComment.setText("Array sorted");

					} catch (InterruptedException e) {
					}
				}
			});

			quickThread.start();

		}

		// *************Run heap sort simulation*************
		if (heapSortRadioButton.isSelected()) {

			cl.show(MainPanel, "heapPanel");
			HeapSort hs = new HeapSort(arr);
			heapArr.setText(Formatter.htmlString(arr));
			hs.sort();

			Thread hThread = new Thread(new Runnable() {

				@Override
				public void run() {
					try {

						heapComment.setText(hs.comment.get(0));
						Thread.sleep(1000);

						int count = 0;
						while (count < hs.heap.size()) {

							Thread.sleep(1000);

							heapArr.setText(hs.array.get(count));
							heapTree.setText(hs.heap.get(count));
							heapCurrent.setText(hs.current.get(count));
							heapComment.setText(hs.comment.get(count));
							count++;
						}

					} catch (InterruptedException e) {
					}
				}
			});

			hThread.start();

		}

		// *************Run bucket sort simulation*************
		if (bucketSortRadioButton.isSelected()) {

			// *************Handle bad input in the bucket text field*************
			try {
				
				bucket = Integer.parseInt((bucketTextField.getText()));
				
				if (bucket >= arr.length) {
					JOptionPane.showMessageDialog(WelcomePanel,"Bad Input: number of buckets should be less than array size","Error",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				}catch(NumberFormatException err) {
					
					JOptionPane.showMessageDialog(WelcomePanel,"Bad Input: number of buckets should be an integer","Error",JOptionPane.WARNING_MESSAGE);
					return;
				}
			
			cl.show(MainPanel, "bucketPanel");
			
			
			BucketSort bs = new BucketSort(arr, bucket);
			bs.sort();
			arraySorting.setText(bs.arrayDisplay.get(0));

			Thread bucketThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {

						bucketComment.setText(bs.comment.get(0));

						while (count < bs.bucketsDisplay.size()) {

							Thread.sleep(1000);

							bucketSorting.setText(bs.bucketsDisplay.get(count++));

						}
					} catch (InterruptedException e) {
					}
				}
			});

			bucketThread.start();

			Thread sortedBucketThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {
						bucketThread.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {

						bucketComment.setText(bs.comment.get(1));

						Thread.sleep(2000);

						while (count < bs.sortedbucketsDisplay.size()) {

							Thread.sleep(1000);

							bucketSorting.setText(bs.sortedbucketsDisplay.get(count++));

						}
					} catch (InterruptedException e) {
					}
				}
			});

			sortedBucketThread.start();

			Thread arrThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {
					try {
						sortedBucketThread.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {

						Thread.sleep(1500);

						bucketComment.setText(bs.comment.get(2));

						Thread.sleep(3000);

						while (count < bs.arrayDisplay.size()) {

							Thread.sleep(1000);

							arraySorting.setText(bs.arrayDisplay.get(count++));

						}

						Thread.sleep(1000);

						bucketComment.setText(bs.comment.get(3));

					} catch (InterruptedException e) {
					}
				}
			});

			arrThread.start();

		}

		// *************Run counting sort simulation*************
		if (countingSortRadioButton.isSelected()) {

			cl.show(MainPanel, "countingPanel");
			CountingSort cs = new CountingSort(arr);
			arrPane.setText(Formatter.htmlString(arr));
			cs.sort();

			Thread cThread1 = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {
					try {

						countingComment.setText(cs.comment.get(0));
						countingComment2.setText(cs.comment.get(1));

						Thread.sleep(1000);

						while (count < cs.countingArr.size()) {

							Thread.sleep(1000);

							countingArrPane.setText(
									"<p style=\"font-size:180%;font-family:Tahoma; text-align:center; color: #8da6f0;\">  "
											+ Formatter.arrayString(cs.index) + "</p>\n" + cs.countingArr.get(count++));

						}
					} catch (InterruptedException e) {
					}
				}
			});

			cThread1.start();

			Thread countingSortThread = new Thread(new Runnable() {

				int count = 0;

				@Override
				public void run() {

					try {
						cThread1.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {

						countingComment.setText(cs.comment.get(2));
						countingComment2.setText(cs.comment.get(3));
						countingComment3.setText(cs.comment.get(4));

						Thread.sleep(3000);

						while (count < cs.arrDisp.size()) {

							Thread.sleep(1000);

							arrPane.setText(cs.arrDisp.get(count++));

						}
						countingComment.setText("");
						countingComment2.setText(cs.comment.get(5));
						countingComment3.setText("");

						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			});

			countingSortThread.start();

		}

	}

	// *************Parse string input into integer array*************
	private int[] parseInputArr(String inp) {

		String[] s = inp.split(" ");
		int[] arr = new int[s.length];


		for (int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}

			return arr;

	}


	// *************Hide bucket input when not needed*************
	@Override
	public void stateChanged(ChangeEvent e) {

		if (bucketSortRadioButton.isSelected()) {

			bucketTextField.setVisible(true);
			txtNumberOfBuckets.setVisible(true);
			bucketTextField.setEnabled(true);
		}

		else {

			bucketTextField.setVisible(false);
			txtNumberOfBuckets.setVisible(false);
			bucketTextField.setEnabled(false);

		}

	}
}
