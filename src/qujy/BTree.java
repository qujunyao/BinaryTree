package qujy;
/**
 * ������
 * 
 * @author qujy
 *
 */
public class BTree {
	//Ԫ������
	private Object date;
	
	//�㼶
	private int floor;
	
	//���ӽ��
	private BTree left;
	
	//���ӽڵ�
	private BTree right;
	
	//xԭ����
	private int x;
	
	//x����
	private int x1;
	
	//y����
	private int y1;
	
	//x2����
	private int x2;
	
	//y2����
	private int y2;
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public Object getDate() {
		return date;
	}
	
	public void setDate(Object date) {
		this.date = date;
	}
	
	public BTree getLeft() {
		return left;
	}
	
	public void setLeft(BTree left) {
		this.left = left;
	}
	
	public BTree getRight() {
		return right;
	}
	
	public void setRight(BTree right) {
		this.right = right;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX1() {
		return x1;
	}
	
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public BTree() {}
	
	
	/**
	 * ���췽��:�������ڵ�
	 * @param date
	 * @param floor
	 * @param x
	 */
	public BTree(Object date,int floor,int x) {
		this.date = date;
		this.floor = floor;
		this.x = x;
		this.x1 = 2*x-1;
		this.x2 = this.x1+1;
		this.y1 = 0;
		this.y2 = 0;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * ���췽��:�����ӽڵ�
	 * @param date ����
	 * @param floor ��ǰ�ڵ�Ĳ㼶
	 * @param root ���ڵ�
	 * @param leftOrRight ���㻹���ҽڵ� true:�� false:��
	 * @param level �������Ĳ㼶
	 */
	public BTree(Object date,int floor,BTree root,boolean leftOrRight,int level){
		this.date = date;
		this.floor = floor;
		this.left = null;
		this.right = null;
		this.x = comX(root.getX(),floor,leftOrRight);
		this.x1 = this.x * 2 - 1;
		this.x2 = this.x1+1;
		this.y1 = Power(level)-Power(floor);
		this.y2 = this.y1;
	}
	
	/**
	 * ���ݸ��ڵ�,�����ӽڵ������
	 * @param rootX ���ڵ������
	 * @param rootFl �ڵ�Ĳ㼶
	 * @param leftOrRight ���㻹���ҽ�� true:��,false:��
	 * @return �ӽڵ�����
	 */
	public static int comX(int rootX,int rootFl,boolean leftOrRight) {
		int childerns = Power(rootFl)-2;
		int x = 0;
		if(leftOrRight) {//����
			x= rootX-((childerns+1)/2+1);
		}else{//�ҽڵ�
			x= rootX+(childerns+1)/2+1;
		}
		return x;
	}
	
	/**
	 * 2����
	 * @param t
	 * @return
	 */
	private static int Power(int t) {  
		return (int) Math.ceil((Math.pow(2,t)));
	}
	
	public String toString2() {
		return "BTree [date=" + date + ", floor=" + floor +  ", x1=" + x1 + ", y1="	+ y1 + ", x2=" + x2 + ", y2=" + y2 +", left=" + left + ", right=" + right + "]";
	}
	
	public String toString() {
		return "BTree [date=" + date +", x="+x+ ", x1=" + x1 + ", y1="	+ y1 + ", x2=" + x2 + ", y2=" + y2+"]";
	}
	

}
