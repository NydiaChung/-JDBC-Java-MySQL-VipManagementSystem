package mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public interface IMapper {
	ArrayList map(ResultSet rst);//声明一个方法存着结果集。
}
