import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OtpComponent } from './otp/otp.component';
import { HeadingComponent } from './heading/heading.component';
import { DescriptionComponent } from './description/description.component';
import { CartComponent } from './cart/cart.component';
import { ElectronicsComponent } from './electronics/electronics.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { SearchComponent } from './search/search.component';
import {TransferService} from './transfer.service';
import { FashionComponent } from './fashion/fashion.component';
import { EssentialsComponent } from './essentials/essentials.component';
import { PaymentComponent } from './payment/payment.component';
import { FashionDescriptionComponent } from './fashion-description/fashion-description.component';
import { SigninComponent } from './signin/signin.component';
import { AdminComponent } from './admin/admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { GetAllProductsComponent } from './get-all-products/get-all-products.component';
import { OrdersComponent } from './orders/orders.component';
import { FootingComponent } from './footing/footing.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { UsersComponent } from './users/users.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { FaqComponent } from './faq/faq.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    OtpComponent,
    HeadingComponent,
    DescriptionComponent,
    CartComponent,
    ElectronicsComponent,
    WishlistComponent,
    SearchComponent,
    FashionComponent,
    EssentialsComponent,
    PaymentComponent,
    FashionDescriptionComponent,
    SigninComponent,
    AdminComponent,
    AddProductComponent,
    GetAllProductsComponent,
    OrdersComponent,
    FootingComponent,
    UpdateProductComponent,
    UsersComponent,
    AccountDetailsComponent,
    FaqComponent,
    ContactComponent,
    AboutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    TransferService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
