<template>
    <div class="data-table">
        <el-table :data="tableData" stripe style="width:100%">
            <el-table-column prop="Uid" label="編號" width="180"></el-table-column>
            <el-table-column prop="BookName" label="書名" width="180"></el-table-column>
            <el-table-column prop="Author" label="作者"></el-table-column>
            <el-table-column prop="Content" label="書籍內容簡介"></el-table-column>
            <el-table-column prop="BorrowedTime" label="最近借閱時間"></el-table-column>
            <el-table-column prop="Status" label="狀態"></el-table-column>
            <el-table-column fixed="right" label="" width="200">
                <template v-slot="scope">
                    <el-button  @click="borrowBook(scope.row.Uid)" type="success" :disabled="scope.row.Status == 'Borrowed'">借閱</el-button>
                    <el-button  @click="returnBook(scope.row.Uid)" type="warning" :disabled="scope.row.Status == 'Returned'">歸還</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>
  
<script lang="ts">
import { defineComponent, reactive } from 'vue';
import Swal from 'sweetalert2';

export default defineComponent({
    setup() {

        type BookInfoCollection = {
            Uid:string,
            BookName:string,
            Author:string,
            Content:string,
            BorrowedTime:string,
            Status:string,
        }

        const tableData:BookInfoCollection[] = 
        reactive([
            {
                Uid: "011034344344",
                BookName: "給你二本書",
                Author: "蔡維祐",
                Content: "我看看你，你看看我",
                BorrowedTime: "2021-12-04",
                Status: "Borrowed"
            },
            {
                Uid: "021242343435",
                BookName: "程式設計入門",
                Author: "張三",
                Content: "從基礎到進階",
                BorrowedTime: "2022-01-15",
                Status: "Returned"
            },
            {
                Uid: "031657687987",
                BookName: "資料結構與演算法",
                Author: "李四",
                Content: "學習資料結構與常見演算法",
                BorrowedTime: "2022-03-27",
                Status: "Borrowed"
            },
            {
                Uid: "041245876765",
                BookName: "JavaScript 高級程式設計",
                Author: "John Resig",
                Content: "深入探索 JavaScript 的進階概念與技巧",
                BorrowedTime: "2022-02-10",
                Status: "Returned"
            },
            {
                Uid: "051245343434",
                BookName: "Python機器學習",
                Author: "Sebastian Raschka",
                Content: "從機器學習基礎到實際應用",
                BorrowedTime: "2022-05-20",
                Status: "Borrowed"
            },
            {
                Uid: "061245654564",
                BookName: "網頁設計入門",
                Author: "王五",
                Content: "學習網頁設計的基礎知識與技巧",
                BorrowedTime: "2022-07-10",
                Status: "Returned"
            },
            {
                Uid: "071245987676",
                BookName: "資料庫設計與管理",
                Author: "張六",
                Content: "深入瞭解資料庫設計與管理的原則與實踐",
                BorrowedTime: "2022-08-25",
                Status: "Borrowed"
            },
            {
                Uid: "081245453453",
                BookName: "遊戲開發入門",
                Author: "陳七",
                Content: "從遊戲開發的基礎到進階",
                BorrowedTime: "2022-09-15",
                Status: "Borrowed"
            },
            {
                Uid: "091245765656",
                BookName: "物聯網應用與開發",
                Author: "劉八",
                Content: "探索物聯網技術與應用的全面指南",
                BorrowedTime: "2022-10-05",
                Status: "Returned"
            },
            {
                Uid: "101245876789",
                BookName: "網路安全與攻擊防禦",
                Author: "林九",
                Content: "保護網路安全與防禦常見攻擊的策略與技巧",
                BorrowedTime: "2022-11-20",
                Status: "Borrowed"
            },
            {
                Uid: "111245343434",
                BookName: "數據分析與挖掘",
                Author: "王十",
                Content: "從數據分析到挖掘隱藏模式與趨勢",
                BorrowedTime: "2022-12-10",
                Status: "Returned"
            },
            {
                Uid: "121245765654",
                BookName: "人工智慧基礎",
                Author: "劉十一",
                Content: "深入瞭解人工智慧的基本概念與應用",
                BorrowedTime: "2023-01-08",
                Status: "Borrowed"
            },
            {
                Uid: "131245987676",
                BookName: "前端開發進階",
                Author: "張十二",
                Content: "探索前端開發的進階技術與最佳實踐",
                BorrowedTime: "2023-02-15",
                Status: "Returned"
            },
            {
                Uid: "141245453453",
                BookName: "電腦網絡與通信",
                Author: "陳十三",
                Content: "瞭解計算機網絡與通信的原理與技術",
                BorrowedTime: "2023-03-22",
                Status: "Borrowed"
            },
            {
                Uid: "151245876789",
                BookName: "軟體工程導論",
                Author: "林十四",
                Content: "從軟體開發生命週期到團隊協作",
                BorrowedTime: "2023-04-12",
                Status: "Returned"
            },
        ])

        const borrowBook = (Uid:string):Boolean =>{
            const book:BookInfoCollection|undefined= tableData.find(x => x.Uid === Uid);
            if (book == undefined) Swal.fire('系統錯誤', '找不到書籍', 'error');
            else book.Status = "Borrowed"
            return false;
        }

        const returnBook = (Uid:string):Boolean =>{
            const book:BookInfoCollection|undefined= tableData.find(x => x.Uid === Uid);
            if (book == undefined) Swal.fire('系統錯誤', '找不到書籍', 'error');
            else book.Status = "Returned"
            return false;
        }

        return {
            borrowBook,
            returnBook,
            tableData,
        };
    }
})
</script>