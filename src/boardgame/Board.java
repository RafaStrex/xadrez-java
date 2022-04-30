package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if (rows < 1 || columns < 1){
			throw new BoardException("É necessário que haja pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!PositionExists(row, column)) {
			throw new BoardException("Posicao invalida");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Posicao invalida");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void PlacePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean PositionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean PositionExists(Position position) {
		return PositionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece (Position position) {
		if (!PositionExists(position)) {
			throw new BoardException("Posicao invalida");
		}
		return piece(position) != null;
	}

}
