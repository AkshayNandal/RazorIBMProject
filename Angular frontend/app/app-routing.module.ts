import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import {ElectronicsComponent} from './electronics/electronics.component';
import {DescriptionComponent} from './description/description.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { OtpComponent } from './otp/otp.component';
import { EssentialsComponent } from './essentials/essentials.component';
import { FashionComponent } from './fashion/fashion.component';
import {FashionDescriptionComponent} from './fashion-description/fashion-description.component';
import {SigninComponent} from './signin/signin.component';
import {OrdersComponent} from './orders/orders.component';
import { AdminComponent } from './admin/admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { GetAllProductsComponent } from './get-all-products/get-all-products.component';
import {PaymentComponent} from './payment/payment.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UsersComponent } from './users/users.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import {FaqComponent} from './faq/faq.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';



const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'otp',component:OtpComponent},
  {path:'home',component:HomeComponent},
  {path:'electronics',component:ElectronicsComponent},
  {path:'itemDescription/:p1',component:DescriptionComponent},
  {path:'cart',component:CartComponent},
  {path:'wishlist',component:WishlistComponent},
  {path:'search/:p1',component:SearchComponent},
  {path:'essentials',component:EssentialsComponent},
  {path:'fashion',component:FashionComponent},
  {path:'fashionDescription/:p1',component:FashionDescriptionComponent},
  {path:'signin',component:SigninComponent},
  {path:'orders',component:OrdersComponent},
  {path:'admin',component:AdminComponent},
  {path:'addproduct',component:AddProductComponent},
  {path:'getproduct',component:GetAllProductsComponent},
  {path:'orders',component:OrdersComponent},
  {path:'payment/:p1',component:PaymentComponent},
  {path:'update/:p1',component:UpdateProductComponent},
  {path:'users',component:UsersComponent},
  {path:'account',component:AccountDetailsComponent},
  {path:'faq',component:FaqComponent},
  {path:'contact',component:ContactComponent},
  {path:'about',component:AboutComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }



