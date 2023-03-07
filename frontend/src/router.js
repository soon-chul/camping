
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReserveManager from "./components/listers/ReserveCards"
import ReserveDetail from "./components/listers/ReserveDetail"

import SiteManager from "./components/listers/SiteCards"
import SiteDetail from "./components/listers/SiteDetail"

import RentManager from "./components/listers/RentCards"
import RentDetail from "./components/listers/RentDetail"


import RentalnfoView from "./components/RentalnfoView"
import RentalnfoViewDetail from "./components/RentalnfoViewDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reserves',
                name: 'ReserveManager',
                component: ReserveManager
            },
            {
                path: '/reserves/:id',
                name: 'ReserveDetail',
                component: ReserveDetail
            },

            {
                path: '/sites',
                name: 'SiteManager',
                component: SiteManager
            },
            {
                path: '/sites/:id',
                name: 'SiteDetail',
                component: SiteDetail
            },

            {
                path: '/rents',
                name: 'RentManager',
                component: RentManager
            },
            {
                path: '/rents/:id',
                name: 'RentDetail',
                component: RentDetail
            },


            {
                path: '/rentalnfos',
                name: 'RentalnfoView',
                component: RentalnfoView
            },
            {
                path: '/rentalnfos/:id',
                name: 'RentalnfoViewDetail',
                component: RentalnfoViewDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },



    ]
})
