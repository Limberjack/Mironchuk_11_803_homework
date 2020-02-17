package tree;

public enum NodeType{
    COUNTRY(1),
    REGION(2),
    CITY(3),
    DISTRICT(4),
    STREET(5),
    HOUSE(6);

    private int type;
    NodeType(int i){
        type = i;
    }
}
