<template>
    <div>
        <el-button type="primary" v-on:click.prevent="push">Create a new workout</el-button>
        <UsersList />
        <router-view></router-view>
    </div>
</template>

<script>
    import UsersList from "./UsersList";

    export default {
        name: "UserPage",
        components: {
            UsersList
        },
        methods: {
            push: function () {
                this.$router.push('/new_train')
            }
        }
    }
</script>

<style scoped>

</style>