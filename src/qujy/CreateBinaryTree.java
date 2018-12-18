package qujy;

import java.util.ArrayList;
import java.util.List;

/**
 * �������������
 * 
 * @author qujy
 *
 */
public class CreateBinaryTree {
	
	/** �㼶 */
	private int level;
	
	/** �ڵ�Ԫ�� */
	private BTree bTree;
	
	/** �ӽڵ���� */
	private long num;
	
	/** �ӽڵ㼯�� */
	private List<BTree> childTrees = new ArrayList<>();
	
	public BTree getbTree() {
		return bTree;
	}
	
	public long getNum() {
		return num;
	}

	public int getLevel() {
		return level;
	}
	
	public List<BTree> getChildTrees() {
		return childTrees;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<childTrees.size();i++) {
			buffer.append("\n\t\t"+childTrees.get(i).toString());
		}
		return "CreateBinaryTree [\n\t�㼶=" + level + ", \n\t�ӽڵ����=" + num + ", \n\t�ӽڵ㼯��=[" + buffer.toString() + "\n\t]\n]";
	}

	/**
	 * ͼ�λ�������
	 */
	public void print() {
		String [][] st = new String[(int) (Math.ceil((Math.pow(2,level)))-1)][(int) (Math.ceil((Math.pow(2,level+1))))];
		for(int i = 0;i<this.childTrees.size();i++){
			BTree b = childTrees.get(i);
			//���ڵ�
			st[b.getY1()][b.getX1()] = b.getDate().toString().substring(0,1);
			st[b.getY2()][b.getX2()] = b.getDate().toString().substring(1);
			
			//������֦
			if(b.getLeft()!=null) {
				int z = Power(b.getFloor()-1)-1;
				for(int j = 1;j<=z;j++) {
					st[b.getY1()+j][b.getX1()-j] = "/";
				}
			}
			
			//������֦
			if(b.getRight()!=null) {
				int z = Power(b.getFloor()-1)-1;
				for(int j = 1;j<=z;j++) {
					st[b.getY2()+j][b.getX2()+j] = "\\";
				}
			}
		}
		
		//��ӡ
		for(int i = 0;i<st.length;i++){
			for(int j = 0;j<st[i].length;j++){
				if(st[i][j]==null||"".equals(st[i][j])) {
					st[i][j]= " ";
				}
				System.out.print(st[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * ���췽��1��
	 * @param level ����㼶 
	 */
	public CreateBinaryTree(int level){
		this.level = level;
		this.num = (long) (Math.random()*(totalNumber(level)+1));//������ɽ�����
		this.bTree = create();
	}
	
	/**
	 * ���췽��2 
	 * @param level ����㼶 
	 * @param nums ��ȥ�㼶��,������Ľ�����(�����ֵ������)
	 */
	public CreateBinaryTree(int level,long nums){
		this.level = level;
		if(nums>totalNumber(level)){
			this.num = (long) (Math.random()*(totalNumber(level)+1));//������ɽ�����
			System.out.println("����Ľ������������Ľ�����:"+totalNumber(level));
			System.exit(1);
		}else{
			this.num = nums;
		} 
		this.bTree = create();
	}
	
	/**
	 * ����������
	 * @return
	 */
	private BTree create(){
		//���������Ŀ��
		MakeStruc2(null,1,false);
		//MakeStruc(new BTree(GetOneValue.num(),level,Power(level-1)),level);
		//ѭ����ӽ׶�
		while(num>0){
			addOnePoint(this.bTree, level);
		}
		this.num = this.childTrees.size();
		return this.bTree;
	}
	
	/**
	 * ���ɿ�ܽṹ(���ӽڵ㿪ʼ����)
	 * @param a 
	 * @param level
	 * @return
	 */
	@SuppressWarnings("unused")
	private BTree MakeStruc(BTree a, int level){
		BTree root = a;
		if(level==1){
			return root;
		}else{
			root = MakeStruc(a,level-1);
		}
		int floor = root.getFloor();
		BTree tree = null;
		boolean r=TrueOrFalse();
		if(r){
			tree = new BTree(GetOneValue.num(),floor-1,root,true,this.level);
			tree.setLeft(root);
		}else{
			tree = new BTree(GetOneValue.num(),floor-1,root,false,this.level);
			tree.setRight(root);
		}
		return tree;
	}
	
	/**
	 * ���ɿ�ܽṹ (�Ӹ��ڵ㿪ʼ����)
	 * @param a 
	 * @param level
	 * @return
	 */
	private BTree MakeStruc2(BTree a, int level,boolean lor){
		if(level == this.level) {
			//��ʾ���Ǹ��ڵ�
			this.bTree= new BTree(GetOneValue.num(),level,Power(level-1));
			this.childTrees.add(this.bTree);
			if(lor) {
				this.bTree.setLeft(a);
			}else {
				this.bTree.setRight(a);
			}
			return this.bTree;
		}else{
			BTree t = new BTree();
			boolean b = TrueOrFalse();
			BTree root = MakeStruc2(t,level+1,b);
			t.setDate(GetOneValue.num());
			t.setFloor(level);
			int x = BTree.comX(root.getX(), t.getFloor(), b);
			int y = Power(this.level)-Power(level);
			t.setX(x);
			t.setX1(2*x-1);
			t.setX2(2*x);
			t.setY1(y);
			t.setY2(y);
			this.childTrees.add(t);
			if(b) {
				root.setLeft(t);
			}else {
				root.setRight(t);
			}
			return t;
		}
	}
	
	/**
	 * ���벻���ķ���
	 * @return
	 */
	private boolean TrueOrFalse() {
		return (int)(2*Math.random())==0?true:false;
	}
	
	/**
	 * ������һ���ӽڵ�
	 * @param b
	 * @param level
	 * @return
	 */
	private BTree addOnePoint(BTree b,int level){
		BTree t = null;
		if(b.getFloor()==2){
			if(b.getLeft()==null&&b.getRight()==null){
				if(TrueOrFalse()){
					t = new BTree(GetOneValue.num(), b.getFloor()-1,b,true,this.level);
					b.setLeft(t);
					this.childTrees.add(t);
					num--;
				}else{
					t = new BTree(GetOneValue.num(), b.getFloor()-1,b,false,this.level);
					b.setRight(t);
					this.childTrees.add(t);
					num--;
				}
			}else if(b.getLeft()==null){
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,true,this.level);
				b.setLeft(t);
				this.childTrees.add(t);
				num--;
			}else if(b.getRight()==null){
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,false,this.level);
				b.setRight(t);
				this.childTrees.add(t);
				num--;
			}
			return b;
		}
		BTree left = b.getLeft();
		BTree right = b.getRight();
		if(left==null&&right==null){
			if(TrueOrFalse()){
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,true,this.level);
				b.setLeft(t);
				this.childTrees.add(t);
				num--;
			}else{
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,false,this.level);
				b.setRight(t);
				this.childTrees.add(t);
				num--;
			}
		}else if(left==null) {
			if(TrueOrFalse()){
				b = addOnePoint(b.getRight(), level-1);
			}else{
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,true,this.level);
				b.setLeft(t);
				this.childTrees.add(t);
				num--;
			}
		}else if(right==null){
			if(TrueOrFalse()){
				b = addOnePoint(b.getLeft(), level-1);
			}else{
				t = new BTree(GetOneValue.num(), b.getFloor()-1,b,false,this.level);
				b.setRight(t);
				this.childTrees.add(t);
				num--;
			}
		}else{
			if(TrueOrFalse()){
				b = addOnePoint(b.getLeft(), level-1);
			}else{
				b = addOnePoint(b.getRight(), level-1);
			}
		}
		
		return b;
	}
	
	/**
	 * ���������ߵĽ���⣬��������������
	 * @param t
	 * @return
	 */
	private static int totalNumber(int t){
		return Power(t)-t-1;
	}
	
	/**
	 * 2����
	 * @param t
	 * @return
	 */
	private static int Power(int t) {  
		return (int) Math.ceil((Math.pow(2,t)));
	}
	
	public static void main(String[] args) {
		for(int i = 0;i<100;i++) {
			CreateBinaryTree binaryTree = new CreateBinaryTree(4);
			//System.out.println(binaryTree.toString());
			binaryTree.print();
			System.out.println(i+"-------------------------------------------------------------------------------");
		}
	}

}
