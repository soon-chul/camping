<template>

    <v-card outlined>
        <v-card-title>
            Rentalnfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="SiteId" v-model="item.siteId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="SiteName" v-model="item.siteName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Posting" v-model="item.posting" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="EquipmentName" v-model="item.equipmentName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReserveId" v-model="item.reserveId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'RentalnfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/rentalnfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

