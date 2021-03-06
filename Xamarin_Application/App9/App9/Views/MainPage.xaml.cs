using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

using App9.Models;

namespace App9.Views
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer
    [DesignTimeVisible(false)]
    public partial class MainPage : MasterDetailPage
    {
        
        Dictionary<int, NavigationPage> MenuPages = new Dictionary<int, NavigationPage>();
        
        public MainPage()
        {
            InitializeComponent();

            MasterBehavior = MasterBehavior.Popover;

            MenuPages.Add((int)MenuItemType.Browse, (NavigationPage)Detail);
            MenuPages.Add((int)MenuItemType.About, (NavigationPage)Detail);
            MenuPages.Add((int)MenuItemType.Map, (NavigationPage)Detail);
            MenuPages.Add((int)MenuItemType.Exit, (NavigationPage)Detail);

        }

        public  async Task NavigateFromMenu(int id)
        {
            if (!MenuPages.ContainsKey(id))
            {
                switch (id)
                {
                    case (int)MenuItemType.Browse:
                        MenuPages.Add(id, new NavigationPage(new ItemsPage()));
                        break;
                    case (int)MenuItemType.About:
                        MenuPages.Add(id, new NavigationPage(new AboutPage()));
                        break;
                    case (int)MenuItemType.Map:
                        MenuPages.Add(id, new NavigationPage(new Maps.MyMapPage()));
                        break;
                    case (int)MenuItemType.Exit:
                        DisplayAlert("Success", "Prompt Save Successfully", "OK");
                        //MenuPages.Add(id, new NavigationPage(new AboutPage()));
                        //что то тут ддолжно происходить
                        break;
                }
            }

            var newPage = MenuPages[id];

            if (newPage != null && Detail != newPage)
            {
                Detail = newPage;

                if (Device.RuntimePlatform == Device.Android)
                    await Task.Delay(200);
                    

                IsPresented = false;
            }
        }
    }
}