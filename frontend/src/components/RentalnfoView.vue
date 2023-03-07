<template>

    <v-data-table
        :headers="headers"
        :items="rentalnfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RentalnfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "customerId", value: "customerId" },
                { text: "siteId", value: "siteId" },
                { text: "siteName", value: "siteName" },
                { text: "posting", value: "posting" },
                { text: "equipmentName", value: "equipmentName" },
                { text: "reserveId", value: "reserveId" },
            ],
            rentalnfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/rentalnfos'))

            temp.data._embedded.rentalnfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.rentalnfo = temp.data._embedded.rentalnfos;
        },
        methods: {
        }
    }
</script>

