/// <reference types="cypress" />


describe('Automation Test Sauce Demo for Checkout Item', () =>{
    before(()=>{
        cy.visit('https://www.saucedemo.com')
    });

    it('Login with valid data', () =>{
        cy.fixture("saucedemo").then(saucedemo =>{
            const username = saucedemo.username
            const password = saucedemo.password

            cy.get('#user-name').should('be.visible')
            cy.get('#user-name').clear()
            cy.get('#user-name').type(username)

            cy.get('#password').should('be.visible')
            cy.get('#password').clear()
            cy.get('#password').type(password)

            cy.get('#login-button').should('be.visible')
            cy.get('#login-button').click()
        })

        cy.url().should('include', 'inventory.html')
        cy.contains('Sauce Labs Backpack').should('be.visible')
        cy.get('#add-to-cart-sauce-labs-backpack').should('be.visible')
        cy.get('#add-to-cart-sauce-labs-backpack').click()
        cy.get('#remove-sauce-labs-backpack').should('be.visible')

        cy.get('.shopping_cart_badge').should('be.visible')
        cy.get('#shopping_cart_container').click()

        cy.url().should('include', 'cart.html')
        cy.contains('Sauce Labs Backpack').should('be.visible')
        cy.get('#remove-sauce-labs-backpack').should('be.visible')
        cy.get('#checkout').should('contain.text', 'Checkout')
        cy.get('#checkout').click()

        cy.url().should('include', 'checkout-step-one.html')
        cy.contains('Checkout: Your Information').should('be.visible')

        cy.fixture("saucedemo").then(saucedemo =>{
            const firstName = saucedemo.firstName
            const lastName = saucedemo.lastName
            const postalcode = saucedemo.postalcode

            cy.get('#first-name').should('be.visible')
            cy.get('#first-name').clear()
            cy.get('#first-name').type(firstName)

            cy.get('#last-name').should('be.visible')
            cy.get('#last-name').clear()
            cy.get('#last-name').type(lastName)

            cy.get('#postal-code').should('be.visible')
            cy.get('#postal-code').clear()
            cy.get('#postal-code').type(postalcode)

            cy.get('#continue').should('be.visible')
            cy.get('#continue').click()
        })

        cy.url().should('include', 'checkout-step-two.html')
        cy.contains('Checkout: Overview').should('be.visible')
        cy.contains('Sauce Labs Backpack').should('be.visible')
        cy.get('#finish').should('be.visible')
        cy.get('#finish').click()

        cy.url().should('include', 'checkout-complete.html')
        cy.contains('Checkout: Complete!').should('be.visible')
        cy.get('#back-to-products').should('be.visible')
        cy.get('#back-to-products').click()
        cy.url().should('include', 'inventory.html')
    });

});