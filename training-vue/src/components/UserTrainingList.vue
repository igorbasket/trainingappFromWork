<template>
    <div id="table2">
        <h1>Training List</h1>
        <el-table :data="userTrainings" align="center" style="width: 100%">
            <el-table-column
                    prop="name"
                    label="Name"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="trainingDuration"
                    label="Training duration"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="data"
                    label="Last use date"
                    width="180">
            </el-table-column>
            <el-table-column
                    width="110">
                <el-button class="selectBtn"
                           type="success"
                           @click="selectBtn"
                >Select</el-button>
            </el-table-column>
            <el-table-column
                    width="100">
                <el-button type="primary" >Edit</el-button>
            </el-table-column>
            <el-table-column
                    width="110">
                <el-button class="selectBtn"
                           type="danger"
                >Select</el-button>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "UserTrainingList",
         el: '#table2',
        data() {
            return {
                userTrainings: []
            }
        },
        mounted() {
            this.$http.get('api/training/email/igorbasket@gmail.com/')
                .then(response => {
                    this.userTrainings = response.data
                })
                .catch(response => {
                    //debugger
                    alert(response.status)
                })
        },
        methods:{
            selectBtn(){

            }
        }
    }
</script>

<style scoped>

</style>