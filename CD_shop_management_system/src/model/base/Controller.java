/**Controller Class, this class contain the basic operations
 * and it deals directly with the DC.java class and it interacts with it
 * as an list*/

package model.base;

public class Controller {
    private CD[] cdList;
    private int cnt;
    private int cd_id_cnt; //Default cd number inside a controller

    public Controller() {
        int cd_list_nr = 100;
        this.cdList = new CD[cd_list_nr];
        cnt = 0;
        cd_id_cnt = 0;
    }

    //Add CD
    public void addCD(CD cd) {
        this.cdList[cnt] = cd;
        //adding the cd ID
        this.cdList[cnt].setId(cd_id_cnt++);
        cnt++;

    }

    public CD getItem(int cdID) {
        for (int i = 0; i < cnt; i++) {
//it will select all elements with different id
            if (cdList[i].getId() == cdID) {
                return cdList[i];
            }
        }
        return null;
    }

    public void removeCD(int cdID) {
        CD[] tempArray = new CD[cdList.length];
        int cnt_tmp = 0;
        for (int i = 0; i < cnt; i++) {
//it will select all elements with different id
            if (cdList[i].getId() != cdID && i <= cnt) {
                tempArray[cnt_tmp++] = cdList[i];
            }
        }
//finally assigning temporary list the same array
        cdList = tempArray;
        cnt--; //Decrease cnt because of the removed element
    }

    public CD[] getCdList() {
        return cdList;
    }

    public void setCdList(CD[] cdList) {
        this.cdList = cdList;
        cnt = cdList.length;
    }

    @Override
    public String toString() {

//        return "Controller{" +
//                "cdList=" + Arrays.toString(cdList) +
//                ", cd_list_nr=" + cd_list_nr +
//                ", cnt=" + cnt +
//                '}';
//    }

        StringBuilder tempString_CD_array = new StringBuilder();

        for (CD cd_element : cdList) {
            if (cd_element != null) {
                tempString_CD_array.append("\t").append(cd_element.toString());
            }
        }

        return tempString_CD_array.toString();

    }
}