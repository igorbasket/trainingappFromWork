<template>
    <div align="center">
    <el-table
            :data="userTrainings"
            style="width: 100%"
            max-height="100%"
        >
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
                label="Operations"
                width="120">
            <template slot-scope="scope">
                <el-button
                        @click.native.prevent="selectRow(scope.$index, userTrainings)"
                        type="success">
                    Select
                </el-button>
            </template>
        </el-table-column>
        <el-table-column
                label="Operations"
                width="120">
            <template slot-scope="scope">
                <el-button
                        @click.native.prevent="deleteRow(scope.$index, userTrainings)"
                        type="danger">
                    Remove
                </el-button>
            </template>
        </el-table-column>
    </el-table>
        <small class="tet-muted">Data: {{this.ex}}</small>
    </div>
</template>

<script>
    export default {
        name: "TrainingsTable",
        methods: {
            deleteRow(index, rows) {
                this.delTrain = (rows[index])
                this.$http.delete('api/training/del/'+this.delTrain.name)
                    .then(response => {
                        alert(response.status);
                        rows.splice(index, 1);
                        alert('Training deleted')
                    })
                    .catch(response => {
                        //debugger
                        alert(response.status)

                    })
            },
            selectRow(index, rows) {
                this.training = (rows[index])

                let str = this.training.name
                this.$router.push({name: 'train_display', params: {ex: str}})
            },
        },
        data() {
            return {
                userTrainings: [],
                training: null,
                delTrain: null,
                ex: null
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
    }
</script>

<style scoped>

</style>