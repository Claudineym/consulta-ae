import DashboardPage from "../views/Dashboard/Dashboard.jsx";
import HomePage from "../views/home.jsx";
import Download from "../views/download.jsx"
import Sistema from "../views/Sistema.jsx"

import {
  Dashboard,
  Person,
  ContentPaste,
  LibraryBooks,
  BubbleChart,
  LocationOn,
  Notifications
} from "material-ui-icons";

const appRoutes = [
  {
    path: "/home",
    sidebarName: "Home",
    navbarName: "Bem vindo ao Auditor Eletrônico.",
    icon: Dashboard,
    exact: true,
    component: HomePage
  },
  {
    path: "/download",
    sidebarName: "Download",
    navbarName: "Download dos arquivos",
    icon: Dashboard,
    exact: true,
    component: Download
  },
  {
    path: "/sistema",
    sidebarName: "Sistemas",
    navbarName: "Sistemas",
    icon: Dashboard,
    exact: true,
    component: Sistema
  },
  { redirect: true, path: "/", to: "/home", navbarName: "Redirect" }
];

export default appRoutes;
