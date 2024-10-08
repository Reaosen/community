package codingforlove.community.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    public void setPagination(Integer totalCount, Integer page, Integer size) {

        Integer totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;

        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;
        this.page = page;
        this.totalPage = totalPage;
        pages.add(page);

        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }


        //是否展示上一页
        showPrevious = page != 1;
        //是否展示后一页
        showNext = !page.equals(totalPage);
        //是否显示第一页
        showFirstPage = !pages.contains(1);
        //是否显示最后一页
        showEndPage = !pages.contains(totalPage);
    }
}
