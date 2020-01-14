<template>
    <div align="center">
        <i style="font-size: large">Creating a training:</i>
        <h1/>
    <el-form :model="newTrainingForm" ref="newTrainingForm" class="demo-dynamic" style="width: 400px" >
        <el-form-item label="Training name"
                      :rules="{required: true, message: 'Exercise can not be null', trigger: 'blur'}">
            <el-input v-model="newTrainingForm.nameTrain"/>
        </el-form-item>
        <el-form-item
                v-for="(domain, index) in newTrainingForm.exercise"
                :label="'Exercise ' + index "
                :key="domain.key"
                :rules="{
      required: true, message: 'Exercise can not be null', trigger: 'blur'
    }"
        >
            <el-input placeholder="Input exercise name" v-model="domain.nameEx"/>
            <el-time-picker placeholder="Pick exercise duration" v-model="domain.timeEx" style="width: 100%;"/>
<!--            <el-input type="time" v-model="domain.timeEx"></el-input>-->
            <el-button @click.prevent="removeDomain(domain)">Delete</el-button>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('newTrainingForm')">Submit</el-button>
            <el-button @click="addDomain">New exercise</el-button>
            <el-button @click="resetForm('newTrainingForm')">Reset</el-button>
        </el-form-item>
        <small class="tet-muted">Data: {{newTrainingForm}}</small>
    </el-form>




    </div>
</template>

<script>
    export default {
        name: "NewTraining",
        data() {
            return {
                newTrainingForm: {
                    exercise: [{
                        timeEx: 0,
                        nameEx: '',
                    }],
                    nameTrain: ''
                },
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        alert('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            removeDomain(item) {
                var index = this.newTrainingForm.exercise.indexOf(item);
                if (index !== -1) {
                    this.newTrainingForm.exercise.splice(index, 1);
                }
            },
            addDomain() {
                this.newTrainingForm.exercise.push({
                    timeEx: 0,
                    nameEx: ''
                });
            }
        },

    }
</script>

<style scoped>

</style>