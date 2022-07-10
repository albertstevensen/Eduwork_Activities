/// <reference types ="cypress" />

describe('saucedemo automated testing', () =>{
    it('saucedemo simulation buying item process', () =>{
        cy.visit('https://www.saucedemo.com/')
        
        //Login ke dalam saucedemo.com
        cy.fixture("saucedemo").then(saucedemo =>{
            const username = saucedemo.username
            const password = saucedemo.password
            const firstName = saucedemo.firstName
            const lastName = saucedemo.lastName
            const postalCode = saucedemo.postalCode

            //Fill username field
            cy.get('#user-name').clear()
            cy.get('#user-name').type(username)

            //Fill password field
            cy.get('#password').clear()
            cy.get('#password').type(password)

            //Click button Login
            cy.contains('Login').click()

            //Add Sauce Lab Backpack
            cy.get('#add-to-cart-sauce-labs-backpack').click()
            
            //Click cart icon
            cy.get('#shopping_cart_container').click()

            //Click checkout button
            cy.get('#checkout').click()

            //Fill checkout step one field
            cy.get('#first-name').clear()
            cy.get('#first-name').type(firstName)

            cy.get('#last-name').clear()
            cy.get('#last-name').type(lastName)

            cy.get('#postal-code').clear()
            cy.get('#postal-code').type(postalCode)

            cy.contains('Continue').click()
            
        })
    });
});